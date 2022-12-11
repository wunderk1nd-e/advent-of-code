package ltd.k1nd.adventOfCode.y2022.day2

object DayTwoSolver {

  def calculateScore(str: String): Int = {
    val rounds = Parser.partOneParser(str)
    Scorer.scoreGame(rounds)

  }

  def calculateScoreTwo(str: String): Int = {
    val rounds = Parser.partTwoParser(str)
    Scorer.scoreGameTwo(rounds)

  }

}
