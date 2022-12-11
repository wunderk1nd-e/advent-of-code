package ltd.k1nd.adventOfCode.y2022.day10

import cats.collections.Dequeue
import ltd.k1nd.adventOfCode.y2022.day10.Instruction.PendingMutation

private[day10] case class State(x: Int, instructions: Dequeue[Instruction]) {
  def addInstruction(i: Instruction): State =
    State(x, instructions.snoc(i))

  def tick: State = {
    val (maybeHead, maybeTail) = instructions.uncons.unzip
    val tail = maybeTail.getOrElse(Dequeue.empty[Instruction])
    maybeHead match {
      case Some(PendingMutation(delta)) => State(x + delta, tail)
      case _                            => State(x, tail)
    }
  }

  override def toString: String = s"State{x=$x, pending=$instructions}"
}

private[day10] object State {
  val Initial: State = State(1, Dequeue.empty)
}

private[day10] case class ClockState(cycle: Long, state: State)
