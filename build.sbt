
scalaVersion := "2.12.7"


name := "dds"
organization := "de.dds"
version := "1.0"


val circeVersion = "0.10.0"

libraryDependencies ++= Seq(
    "io.circe" %% "circe-core" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "io.circe" %% "circe-parser" % circeVersion,
    "org.scalatest" %% "scalatest" % "3.0.5" % Test
)