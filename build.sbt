name := "ScalaWithCats"

version := "0.1"

scalaVersion := "2.13.2"



libraryDependencies +=
  "org.typelevel" %% "cats-core" % "2.1.1"

scalacOptions ++= Seq(
  "-Xfatal-warnings",

)
