package ltd.k1nd.adventOfCode.y2022.day7

import cats.data.Chain
import cats.implicits._

object DaySevenSolver {
  //part 1
  def sumOfSmallDirectories(input: String): Int = {
    val parsed = parseUnsafe(input)
    val directories = InferStructure.infer(parsed)
    directories.toList.foldMap {
      case (_, size) if size < 100000 => size
      case _                          => 0
    }
  }

  //part 2
  def findDirectoryToDelete(
      diskSize: Int,
      spaceRequiredForUpdate: Int
  )(input: String): Option[(Path, Int)] = {
    val parsed = parseUnsafe(input)
    val directoriesSortedBySize =
      Chain.fromIterableOnce(InferStructure.infer(parsed)).sortBy(_._2)

    val rootSize =
      directoriesSortedBySize.lastOption.getOrElse((Path.Root, 0))._2
    val freeBytesOnDisk = diskSize - rootSize
    val extraBytesNeeded = spaceRequiredForUpdate - freeBytesOnDisk

    directoriesSortedBySize.collectFirst {
      case pair @ (_, size) if size >= extraBytesNeeded => pair
    }
  }

  //Happy for this to explode if it fails to parse input...
  private def parseUnsafe(input: String): Seq[TerminalAction] = {
    fastparse.parse(input, Parser.commands(_)).get.value
  }
}
