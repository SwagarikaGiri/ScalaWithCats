package part4FunctorApplicativeMonad
import scala.util.Random
import scala.concurrent.{Future,Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
object LimitaationsOfFuture  extends App{

  val future1 = {
    // Initialize Random with a fixed seed:
    val r = new Random(0L)
    println(r.nextInt)
    println(r.nextInt)
    println(r.nextInt)
    // nextInt has the side-effect of moving to
    // the next random number in the sequence:
    val x = Future(r.nextInt)
    for {
      a <- x
      b <- x
    } yield (a, b)
  }
  val future2 = {
    val r = new Random(0L)
    for {
      a <- Future(r.nextInt)
      b <- Future(r.nextInt)
    } yield (a, b)
  }
  val result1 = Await.result(future1, 1.second)
  // result1: (Int, Int) = (-1155484576,-1155484576)
  val result2 = Await.result(future2, 1.second)
  // result2: (Int, Int) = (-1155484576,-723955400)
  println(result1)
  println(result2)

}
