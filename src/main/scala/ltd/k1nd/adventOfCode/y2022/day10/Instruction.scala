package ltd.k1nd.adventOfCode.y2022.day10

sealed trait Instruction

object Instruction {
  case object NoOp extends Instruction
  case object Processing extends Instruction
  case class PendingMutation(delta: Int) extends Instruction
}
