package part4FunctorApplicativeMonad

import scala.concurrent.{Future,Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object BasicCodeFunctor extends App{


  val future: Future[String]={
    Future(123)
      .map(n=>n+1)
      .map(n=>n*2)
      .map(n=> s"$n" +" !")
  }

  println(future)

  println(Await.result(future,1.second))
}
