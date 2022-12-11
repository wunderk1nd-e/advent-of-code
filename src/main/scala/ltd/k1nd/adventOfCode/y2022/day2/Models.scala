package ltd.k1nd.adventOfCode.y2022.day2

sealed trait Shape {
  def score: Int
  def wins: Shape
  def loses: Shape
}

object Shape {
  def fromString(str: String) = str match {
    case "A" | "X" => Rock
    case "B" | "Y" => Paper
    case "C" | "Z" => Scissors
  }
  case object Paper extends Shape {
    override val score: Int = 2
    override val wins: Shape = Rock

    override val loses: Shape = Scissors
  }

  case object Rock extends Shape {
    override val score: Int = 1
    override val wins: Shape = Scissors

    override val loses: Shape = Paper

  }

  case object Scissors extends Shape {
    override val score: Int = 3
    override val wins: Shape = Paper

    override val loses: Shape = Rock
  }
}

case class Round(theirs: Shape, yours: Shape)

case class RoundTwo(theirs: Shape, outcome: String)

object Outcome {

  def yourHand(round: RoundTwo): Shape = {
    round.outcome match {
      case "X" => round.theirs.wins
      case "Y" => round.theirs
      case "Z" => round.theirs.loses
    }
  }

}
