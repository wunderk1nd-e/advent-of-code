package ltd.k1nd.adventOfCode.y2022.day1

object DayOneSolver {
  def parse(input: String): List[Elf] = input
    .split("\n\n")
    .map { payload =>
      Elf(payload.split("\n").map(_.toInt).toList)
    }
    .toList

  def findMostBurdenedElf(input: String): Option[Elf] =
    findMostBurdenedElves(input)(1).headOption

  def findMostBurdenedElves(input: String)(n: Int): List[Elf] =
    parse(input)
      .sortBy(_.totalPayload)(implicitly[Ordering[Int]].reverse)
      .take(n)
}

case class Elf(payloads: List[Int]) {
  val totalPayload: Int = payloads.sum
}
