name := "akka-http-heroku-template"

version := "1.1"

scalaVersion := "2.12.2"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= {
  val akkaVersion = "10.0.8"
  Seq(
    "com.typesafe.akka" %% "akka-http" % akkaVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaVersion
  )
}

enablePlugins(JavaAppPackaging)
