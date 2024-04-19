ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.13"

lazy val root = (project in file("."))
  .settings(
    name := "spark-server-docker"
  )



libraryDependencies += "org.apache.spark" %% "spark-connect-client-jvm" % "3.4.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.4.0"  % "provided"