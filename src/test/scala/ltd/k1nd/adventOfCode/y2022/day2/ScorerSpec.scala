package ltd.k1nd.adventOfCode.y2022.day2

import ltd.k1nd.adventOfCode.y2022.day2.Fixtures.{
  ExpectedCorrectParsedExample,
  ExpectedIncorrectParsedExample
}
import weaver.FunSuite

object ScorerSpec extends FunSuite {
//  test("Example case score should be 15") {
//    val score = Scorer.scoreGame(ExpectedIncorrectParsedExample)
//    assert(score == 15)
//  }

  test("Example case score should be 12") {
    val score = Scorer.scoreGameTwo(ExpectedCorrectParsedExample)
    assert(score == 12)
  }
}
