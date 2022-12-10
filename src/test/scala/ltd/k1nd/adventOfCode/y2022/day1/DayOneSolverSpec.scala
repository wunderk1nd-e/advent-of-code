package ltd.k1nd.adventOfCode.y2022.day1

import ltd.k1nd.adventOfCode.y2022.day1.Fixtures._
import weaver.FunSuite

object DayOneSolverSpec extends FunSuite {
  test("Parsing works as expected") {
    assert(DayOneSolver.parse(ExampleInput) == ExpectedParsedExample)
  }

  test("Example solution is as expected") {
    val mostBurdenedElf = DayOneSolver.findMostBurdenedElf(ExampleInput)
    assert(mostBurdenedElf.get == Elf(List(7000, 8000, 9000)))
    assert(mostBurdenedElf.get.totalPayload == 24000)
  }

  test("Puzzle input solution") {
    val mostBurdenedElf = DayOneSolver.findMostBurdenedElf(PuzzleInput)
    assert(mostBurdenedElf.get.totalPayload == 69281)
  }

  test("Example most burdened 3 elves") {
    val mostBurdenedElf = DayOneSolver.findMostBurdenedElves(ExampleInput)(3)
    assert(mostBurdenedElf.map(_.totalPayload).sum == 45000)
  }

  test("Puzzle input most burdened 3 elves") {
    val mostBurdenedElf = DayOneSolver.findMostBurdenedElves(PuzzleInput)(3)
    assert(mostBurdenedElf.map(_.totalPayload).sum == 201524)
  }
}
