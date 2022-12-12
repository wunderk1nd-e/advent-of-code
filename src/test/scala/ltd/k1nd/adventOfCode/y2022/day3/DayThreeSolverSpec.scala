package ltd.k1nd.adventOfCode.y2022.day3

import ltd.k1nd.adventOfCode.y2022.day3.Fixtures.{ExampleInput, PuzzleInput}
import weaver.FunSuite

object DayThreeSolverSpec extends FunSuite {
  test("Returns expected part A result for example input") {
    val result = DayThreeSolver.calculateSumOfPriorities(ExampleInput)
    assert(result == 157)
  }
  test("Returns expected part A result for puzzle input") {
    val result = DayThreeSolver.calculateSumOfPriorities(PuzzleInput)
    assert(result == 8105)
  }
  test("Returns expected part B result for example input") {
    val result = DayThreeSolver.calculateSumOfBadges(ExampleInput)
    assert(result == 70)
  }
  test("Returns expected part A result for puzzle input") {
    val result = DayThreeSolver.calculateSumOfBadges(PuzzleInput)
    assert(result == 2363)
  }
}
