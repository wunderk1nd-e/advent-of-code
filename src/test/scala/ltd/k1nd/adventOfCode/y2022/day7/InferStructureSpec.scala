package ltd.k1nd.adventOfCode.y2022.day7

import Fixtures.{ExpectedFilesAndSized, ExpectedParsedCommands}
import ltd.k1nd.adventOfCode.y2022.day7.InferStructure
import weaver.FunSuite

object InferStructureSpec extends FunSuite {
  test("Calculate directory sizes") {
    expect(
      InferStructure.infer(ExpectedParsedCommands) == ExpectedFilesAndSized
    )
  }
}
