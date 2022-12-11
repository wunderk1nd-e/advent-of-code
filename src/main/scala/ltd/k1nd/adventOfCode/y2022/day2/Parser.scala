package ltd.k1nd.adventOfCode.y2022.day2

object Parser {

  def partOneParser(input: String): List[Round] = {
    val blah = input.split("\n").toList
    blah.map(x =>
      x.split(" ").toList match {
        case theirs :: ours :: Nil =>
          Round(Shape.fromString(theirs), Shape.fromString(ours))
      }
    )
  }

  def partTwoParser(input: String): List[RoundTwo] = {
    val blah = input.split("\n").toList
    blah.map(x =>
      x.split(" ").toList match {
        case theirs :: ours :: Nil =>
          RoundTwo(Shape.fromString(theirs), ours)
      }
    )
  }

}
