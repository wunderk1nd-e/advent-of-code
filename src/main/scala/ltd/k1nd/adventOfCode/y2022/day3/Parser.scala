package ltd.k1nd.adventOfCode.y2022.day3

object Parser {
  def parse(input: String): List[ElfRucksack] =
    input.split("\n").toList.map { rucksack =>
      val trimmedRucksack = rucksack.trim.toList.map(ItemType.apply)
      val length = trimmedRucksack.length
      val middle = length / 2
      val (firstCompartment, secondCompartment) =
        trimmedRucksack.splitAt(middle)
      ElfRucksack(firstCompartment.toSet, secondCompartment.toSet)
    }
}
