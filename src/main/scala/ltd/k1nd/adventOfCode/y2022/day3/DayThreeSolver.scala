package ltd.k1nd.adventOfCode.y2022.day3

import cats.implicits.toFoldableOps

object DayThreeSolver {
  def calculateSumOfPriorities(input: String): Int = {
    val elves = Parser.parse(input)
    elves.flatMap(_.commonItems).foldMap(_.priority)
  }

  def calculateSumOfBadges(input: String): Int = {
    val elves = Parser.parse(input)
    val teams = elves.grouped(3).toList

    teams
      .map(
        _.map(_.allItems).reduce(
          _ intersect _
        )
      )
      .foldMap(_.head.priority)
  }
}
