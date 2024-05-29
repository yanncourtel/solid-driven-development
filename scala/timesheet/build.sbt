ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % Test
libraryDependencies += "org.mockito" %% "mockito-scala-scalatest" % "1.17.31" % Test

lazy val root = (project in file("."))
  .settings(
    name := "timesheet"
  )
