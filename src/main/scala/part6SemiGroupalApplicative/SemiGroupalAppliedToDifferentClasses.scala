package part6SemiGroupalApplicative
import cats.Semigroupal
import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.higherKinds
import cats.instances.future._
import cats.data.Validated // type of monad transformation
import cats.instances.list._

/*
semigroupal gives unexpected behaviour where List(1,2) and List(3,4) will give cartesian product of them
Other itvtoo may break on first failure and not consider the other failure
key thing product(fa,fb)=>f(a,b)
 */
object SemiGroupalAppliedToDifferentClasses extends App {

  val futurePair = Semigroupal[Future].
    product(Future("Hello"), Future(123))
  println(Await.result(futurePair,1.second))

  val a = Future("Future 1")
  val b = Future("Future 2")
  val result = for {
    x <- a
    y <- b
  } yield (x, y)

  println(result)
  /*
  cats have some known as validate that will enable us to collect all the error
  */

  type AllErrorsOr[A] = Validated[List[String],A]
  // A--> Is error

  val res= Semigroupal[AllErrorsOr].product(
    Validated.invalid(List("1")),
    Validated.invalid(List("Error 2"))

  )

  println(res)


}