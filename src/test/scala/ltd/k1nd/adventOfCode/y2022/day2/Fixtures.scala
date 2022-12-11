package ltd.k1nd.adventOfCode.y2022.day2

import ltd.k1nd.adventOfCode.y2022.day2.Shape._

import scala.io.Source

object Fixtures {
  val ExampleInput = """A Y
                       |B X
                       |C Z""".stripMargin

  val ExpectedIncorrectParsedExample =
    List(Round(Rock, Paper), Round(Paper, Rock), Round(Scissors, Scissors))

  val ExpectedCorrectParsedExample =
    List(RoundTwo(Rock, "Y"), RoundTwo(Paper, "X"), RoundTwo(Scissors, "Z"))

  val PuzzleInput =
    Source.fromResource("DayTwoPuzzleInput.txt").getLines().mkString("\n")

}
