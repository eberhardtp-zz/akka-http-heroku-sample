package com.example

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer

import scala.concurrent.Future
import scala.util.Properties

object SampleApp extends App {

  implicit val system = ActorSystem("SampleSystem")
  implicit val materializer = ActorMaterializer()

  val port = Properties.envOrElse("PORT", "8080").toInt

  // needed for the future map/flatmap in the end
  implicit val executionContext = system.dispatcher

  val requestHandler: HttpRequest => Future[HttpResponse] = {

    case HttpRequest(GET, Uri.Path("/"), _, _, _) =>
      Future {
        HttpResponse(entity = HttpEntity(
          ContentTypes.`text/html(UTF-8)`,
          s"<html><body>Akka-http web app is running on Heroku!</body></html>"))
      }

    case r: HttpRequest =>
      r.discardEntityBytes() // important to drain incoming HTTP Entity stream
      Future(HttpResponse(404, entity = "Unknown resource!"))

  }

  Http().bindAndHandleAsync(requestHandler, "0.0.0.0", port)

}