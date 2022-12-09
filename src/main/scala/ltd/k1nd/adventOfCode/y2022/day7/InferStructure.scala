package ltd.k1nd.adventOfCode.y2022.day7

import cats.implicits._

object InferStructure {
  def infer(actions: Seq[TerminalAction]): Map[Path, Int] = {
    //Does not include sizes of any subdirectories contained
    val uniqueDirectoriesAndTotalFileSizes = actions
      .foldLeft(State.Initial) { case (state, action) =>
        action match {
          case TerminalAction.NavigateToRoot =>
            state.withPath(Path.Root)
          case TerminalAction.OneLevelDown(subdirectory) =>
            state.updatePath(_.push(subdirectory))
          case TerminalAction.OneLevelUp =>
            state.updatePath(_.pop)
          case TerminalAction.ListFiles(_, files) =>
            state.updateDirectories(_.updated(state.path, files.values.sum))
        }
      }
      .directories
      .toList

    uniqueDirectoriesAndTotalFileSizes.foldMap(
      (generateAllParentPaths _).tupled
    )
  }

  private def generateAllParentPaths(path: Path, size: Int): Map[Path, Int] =
    Iterator
      .unfold(path)(s =>
        s.pop match {
          case `s`     => None
          case newPath => (newPath -> size, newPath).some
        }
      )
      .toMap + (path -> size)

  private case class State(path: Path, directories: Map[Path, Int]) {
    def withPath(newPath: Path) = State(newPath, directories)
    def updatePath(update: Path => Path) = State(update(path), directories)
    def updateDirectories(update: Map[Path, Int] => Map[Path, Int]) =
      State(path, update(directories))
  }
  private object State {
    val Initial: State = State(Path.Root, Map.empty)
  }

}
