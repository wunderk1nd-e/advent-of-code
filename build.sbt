ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "advent-of-code",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.8.0",
      "org.typelevel" %% "cats-effect" % "3.3.14",
      "com.lihaoyi" %% "fastparse" % "2.2.2",
      "co.fs2" %% "fs2-core" % "3.4.0",
      "org.typelevel" %% "cats-collections-core" % "0.9.5",
      "com.chuusai" %% "shapeless" % "2.3.10",
      "com.disneystreaming" %% "weaver-cats" % "0.8.1" % Test
    ),
    testFrameworks += new TestFramework("weaver.framework.CatsEffect")
  )
