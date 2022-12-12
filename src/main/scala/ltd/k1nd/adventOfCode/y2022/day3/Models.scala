package ltd.k1nd.adventOfCode.y2022.day3

case class ElfRucksack(
    compartmentOne: Set[ItemType],
    compartmentTwo: Set[ItemType]
) {
  val commonItems = compartmentOne.intersect(compartmentTwo)
  val allItems = compartmentOne ++ compartmentTwo
}

case class ItemType(char: Char) {
  val priority: Int =
    if (char.isUpper)
      char.toInt - ItemType.UppercaseStartIndex + 27
    else
      char.toInt - ItemType.LowercaseStartIndex + 1
}

object ItemType {
  private val LowercaseStartIndex = 97
  private val UppercaseStartIndex = 65
}
