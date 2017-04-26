name := "akka-http-heroku-sample"

version := "1.0"

scalaVersion := "2.12.2"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= {
  val akkaVersion = "10.0.5"
  Seq(
    "com.typesafe.akka" %% "akka-http" % akkaVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaVersion
  )
}

enablePlugins(JavaAppPackaging)
