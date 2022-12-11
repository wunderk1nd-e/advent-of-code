package ltd.k1nd.adventOfCode.y2022.day10

import cats.Id
import cats.implicits._
import fs2.{Pure, Stream}

object DayTenSolver {

  def calculateState(
      parsed: Stream[Pure, Instruction]
  ): Stream[Pure, ClockState] = {
    val infiniteInstructions = parsed.map(_.some) ++ Stream.constant(None)

    infiniteInstructions
      .scan(State.Initial.some) {
        case (st, None) if st.forall(_.instructions.isEmpty) =>
          Option.empty[State]
        case (Some(state), instruction) =>
          val tickedState = state.tick
          val stateWithNewOperation =
            instruction.fold(tickedState)(tickedState.addInstruction)

          stateWithNewOperation.some
      }
      .unNoneTerminate
      .zipWithIndex
      .map { case (st, idx) => ClockState(idx, st) }
  }

  def signalStrength(input: String)(indices: Set[Long]): Id[Option[Long]] =
    parseAndCalculateStates(input)
      .filter(st => indices.contains(st.cycle))
      .map(st => st.cycle * st.state.x)
      .foldMonoid
      .compile
      .last

  def parseAndCalculateStates(input: String): Stream[Pure, ClockState] = {
    calculateState(
      Parser.parse(input)
    )
  }

  def renderScreen(input: String): String = {
    val states = parseAndCalculateStates(input).drop(1)
    val crt = Stream.emits(0 to 39).repeatN(6)
    val crtAndStates = crt.zip(states)

    crtAndStates
      .foldMap { case (crtIdx, state) =>
        val maybeNewline = if (crtIdx == 39) "\n" else ""
        val char = if ((state.state.x - crtIdx).abs <= 1) "#" else "."
        s"$char$maybeNewline"
      }
      .compile
      .last
      .getOrElse("")
  }
}
