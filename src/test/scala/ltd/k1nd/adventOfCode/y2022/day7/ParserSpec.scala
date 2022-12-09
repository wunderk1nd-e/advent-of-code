package ltd.k1nd.adventOfCode.y2022.day7

import fastparse.Parsed
import Fixtures.{ExampleInput, ExpectedParsedCommands}
import ltd.k1nd.adventOfCode.y2022.day7.Parser
import weaver._

object ParserSpec extends FunSuite {

  test("parse the test example") {
    val parseResult = fastparse
      .parse(
        ExampleInput,
        Parser.commands(_)
      )

    expect(parseResult.get.value == ExpectedParsedCommands)
  }

}
