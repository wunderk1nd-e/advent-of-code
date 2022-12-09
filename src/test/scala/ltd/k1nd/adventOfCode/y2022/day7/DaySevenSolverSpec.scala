package ltd.k1nd.adventOfCode.y2022.day7

import cats.data.Chain
import cats.implicits.catsSyntaxOptionId
import Fixtures.{ExampleInput, PuzzleInput}
import ltd.k1nd.adventOfCode.y2022.day7.{DaySevenSolver, Path}
import weaver.FunSuite

object DaySevenSolverSpec extends FunSuite {
  test("example case should work") {
    val result = DaySevenSolver.sumOfSmallDirectories(ExampleInput)
    assert(result == 95437)
  }

  test("puzzle case should work") {
    val result = DaySevenSolver.sumOfSmallDirectories(PuzzleInput)
    assert(result == 1667443)
  }
  test("input case should work") {
    val result =
      DaySevenSolver.findDirectoryToDelete(
        diskSize = 70000000,
        spaceRequiredForUpdate = 30000000
      )(ExampleInput)
    assert(result.contains((Path(Chain("d")), 24933642)))
  }

  test("puzzle case should work") {
    val result = {
      DaySevenSolver.findDirectoryToDelete(
        diskSize = 70000000,
        spaceRequiredForUpdate = 30000000
      )(PuzzleInput)
    }
    assert(
      result.contains(
        (Path(Chain("jpjgdm", "tgrplmn", "lpv", "bjlcfcfq")), 8998590)
      )
    )

    success
  }

}
