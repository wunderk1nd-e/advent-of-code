package ltd.k1nd.adventOfCode.y2022.day2

import ltd.k1nd.adventOfCode.y2022.day2.Fixtures.{ExampleInput, PuzzleInput}
import weaver.FunSuite

object DayTwoSolverSpec extends FunSuite {

  test("solve the example case (broken)") {
    val result = DayTwoSolver.calculateScore(ExampleInput)

    assert(result == 15)
  }

  test("solve the puzzle case") {
    val result = DayTwoSolver.calculateScore(PuzzleInput)

    assert(result == 11841)
  }

  test("solve the example case (corrected)") {
    val result = DayTwoSolver.calculateScoreTwo(ExampleInput)

    assert(result == 12)
  }

  test("solve the puzzle case (corrected)") {
    val result = DayTwoSolver.calculateScoreTwo(PuzzleInput)

    assert(result == 13022)
  }

}
