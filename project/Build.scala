import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "vokem-play"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "com.google.inject" % "guice" % "3.0",
    "org.mongodb" % "mongo-java-driver" % "2.11.2",
    javaCore,
    javaJdbc,
    javaEbean
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
