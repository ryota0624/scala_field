import ReleaseTransformations._

ThisBuild / organization := "com.github.ryota0624"

lazy val root = (project in file("."))
  .settings(
    name := "scala_field",
    scalaVersion := "2.13.5",
    libraryDependencies ++= Seq(
      "com.github.dwickern" %% "scala-nameof" % "3.0.0",
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "org.scalatest" %% "scalatest" % "3.2.7" % Test,
    ),
    scalacOptions ++= Seq(
      "-language:experimental.macros"
    )
  )

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  setNextVersion,
  commitNextVersion,
)

// test
