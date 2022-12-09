package ltd.k1nd.adventOfCode.y2022.day7

import cats.data.Chain

case class Path(segments: Chain[String]) {
  def pop: Path = segments.initLast.map(c => Path(c._1)).getOrElse(Path.Root)
  def push(subdirectory: String) = Path(segments.append(subdirectory))
  override def toString: String = segments.toList.mkString("/", "/", "")
}

object Path {
  val Root: Path = Path(Chain.empty)
}
