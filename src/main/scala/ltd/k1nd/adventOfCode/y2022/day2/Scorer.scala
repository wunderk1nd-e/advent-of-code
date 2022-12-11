package ltd.k1nd.adventOfCode.y2022.day2

import cats.implicits.toFoldableOps

object Scorer {
  private def scoreRound(round: Round): Int = {
    val result =
      if (round.yours == round.theirs) 3
      else if (round.theirs == round.yours.wins) 6
      else 0

    round.yours.score + result
  }

  def scoreGame(rounds: List[Round]): Int = rounds.foldMap(scoreRound)

  def scoreRoundTwo(round: RoundTwo): Int = {
    val yourTurn = Outcome.yourHand(round)
    scoreRound(Round(round.theirs, yourTurn))

  }
  def scoreGameTwo(rounds: List[RoundTwo]): Int = rounds.foldMap(scoreRoundTwo)
}
