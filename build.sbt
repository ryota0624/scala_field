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

ThisBuild / pomExtra := {
  <url>https://github.com/ryota0624/scala-field</url>
    <licenses>
      <license>
        <name>MIT license</name>
        <url>http://www.opensource.org/licenses/mit-license.php</url>
      </license>
    </licenses>
    <scm>
      <connection>scm:git:github.com/ryota0624/scala-field.git</connection>
      <developerConnection>scm:git:git@github.com:ryota0624/sscala-field.git</developerConnection>
      <url>github.com/ryota0624/scala-field.git</url>
    </scm>
    <developers>
      <developer>
        <id>ryota0624</id>
        <name>ryota0624</name>
        <url>https://github.com/ryota0624</url>
      </developer>
    </developers>
}

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
