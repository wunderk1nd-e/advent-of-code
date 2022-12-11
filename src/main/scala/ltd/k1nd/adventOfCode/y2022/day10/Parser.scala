package ltd.k1nd.adventOfCode.y2022.day10

import ltd.k1nd.adventOfCode.y2022.day10.Instruction._
import fs2.{Pure, Stream}

object Parser {

  private val NoopInput = "noop"
  private val AddxInput = "addx (-?[0-9]*)".r

  private def stringToInstructions(line: String): List[Instruction] =
    line.trim match {
      case NoopInput        => List(NoOp)
      case AddxInput(delta) => List(Processing, PendingMutation(delta.toInt))
    }

  def parse(input: String): Stream[Pure, Instruction] = Stream
    .emits(input.split("\n"))
    .flatMap(str => Stream.emits(stringToInstructions(str)))

}
