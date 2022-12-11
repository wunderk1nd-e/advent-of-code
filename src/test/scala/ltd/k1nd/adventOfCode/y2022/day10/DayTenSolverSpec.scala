package ltd.k1nd.adventOfCode.y2022.day10

import ltd.k1nd.adventOfCode.y2022.day10.DayTenSolver.renderScreen
import ltd.k1nd.adventOfCode.y2022.day10.Fixtures.{
  ExpectedScreenExampleInput,
  ExpectedScreenPuzzleInput,
  LargeTestInput,
  PuzzleCaseInput
}
import weaver.FunSuite

object DayTenSolverSpec extends FunSuite {
  test("Example case gives expected sum strength") {
    val signalStr = DayTenSolver.signalStrength(LargeTestInput)(
      Set(20, 60, 100, 140, 180, 220)
    )
    assert(signalStr == Some(13140))
  }
  test("Puzzle case gives expected sum strength") {
    val signalStr = DayTenSolver.signalStrength(PuzzleCaseInput)(
      Set(20, 60, 100, 140, 180, 220)
    )
    assert(signalStr == Some(17180))
  }
  test("test case should work as expected") {
    assert(renderScreen(LargeTestInput).contains(ExpectedScreenExampleInput))
  }
  test("test case should work as expected") {
    assert(renderScreen(PuzzleCaseInput).contains(ExpectedScreenPuzzleInput))
  }
}
