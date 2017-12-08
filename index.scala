#!/usr/bin/env amm
import ammonite.ops._
import $ivy.`com.typesafe.akka::akka-http:10.0.11`
import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.io.StdIn
import ContentTypes._

@main
def main():Unit = {
  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher
  val route = logRequest(("request", Logging.InfoLevel)) {
    get {
      complete("Hello")
    }
  }
  val address = "0.0.0.0"
  val port = 8080
  val bindingFuture = Http().bindAndHandle(route, address, port)
  println(s"Server online at http://$address:$port/\nPress RETURN to stop...")
  StdIn.readLine()
  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate())
}
