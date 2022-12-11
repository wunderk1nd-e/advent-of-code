package ltd.k1nd.adventOfCode.y2022.day7

import fastparse._
import NoWhitespace._
import cats.implicits.catsSyntaxOptionId
import TerminalAction._
import ltd.k1nd.adventOfCode.y2022.day7.TerminalAction.{
  NavigateToRoot,
  NavigationAction,
  OneLevelDown,
  OneLevelUp
}

object Parser {
  def whitespace[_: P] = CharIn(" ").rep
  def whitespaceAndNewline[_: P] = CharIn(" ").rep.? ~ StringIn("\n")
  def word[_: P] = CharIn("a-zA-Z").rep
  def filename[_: P] = CharIn("a-zA-Z0-9._").rep

  def parseChangeDirectory[_: P]: P[NavigationAction] =
    P("cd") ~ whitespace ~ (P("/").map(_ => NavigateToRoot) | P("..").map(_ =>
      OneLevelUp
    ) | word.!.map(OneLevelDown))

  def parseLsFile[_: P]: P[LsResult] =
    (CharIn("0-9").rep(1).! ~ whitespace ~ filename.!).map {
      case (size, filename) => FileAndSize(filename, size.toInt)
    }

  def parseLsDir[_: P]: P[LsResult] =
    P("dir") ~ whitespace ~ word.!.map(Directory.apply)

  def parseLs[_: P] =
    (P(
      "ls"
    ) ~ whitespaceAndNewline ~ ((parseLsDir | parseLsFile) ~ whitespaceAndNewline.?).rep)
      .map { results =>
        ListFiles(
          results.collect { case Directory(path) => path }.toSet,
          results.collect { case FileAndSize(name, size) =>
            name -> size
          }.toMap
        )
      }

  def command[_: P] =
    (P("$") ~ whitespace).flatMap { _ =>
      (parseChangeDirectory | parseLs)
    }
  def commands[_: P] =
    (whitespaceAndNewline.map(_ => List.empty[NavigationAction]) | command
      .map(
        _.some
      ))./.rep.map(_.flatten)

  sealed trait LsResult
  case class Directory(path: String) extends LsResult
  case class FileAndSize(name: String, size: Int) extends LsResult
}
