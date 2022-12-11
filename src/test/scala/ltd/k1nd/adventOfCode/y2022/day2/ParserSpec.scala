package ltd.k1nd.adventOfCode.y2022.day2

import ltd.k1nd.adventOfCode.y2022.day2.Fixtures.{
  ExampleInput,
  ExpectedCorrectParsedExample,
  ExpectedIncorrectParsedExample
}
import weaver.FunSuite

object ParserSpec extends FunSuite {
  test("Example case should parse (broken parser)") {
    val parsed = Parser.partOneParser(ExampleInput)
    assert(parsed == ExpectedIncorrectParsedExample)
  }

  test("Example case should parse (correct parser)") {
    val parsed = Parser.partTwoParser(ExampleInput)
    assert(parsed == ExpectedCorrectParsedExample)
  }

}
