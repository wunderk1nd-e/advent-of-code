package ltd.k1nd.adventOfCode.y2022.day7

sealed trait TerminalAction

object TerminalAction {
  sealed trait NavigationAction extends TerminalAction

  case object NavigateToRoot extends NavigationAction
  case class OneLevelDown(subdirectory: String) extends NavigationAction
  case object OneLevelUp extends NavigationAction

  case class ListFiles(directories: Set[String], files: Map[String, Int])
      extends TerminalAction
}
