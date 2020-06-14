package part6SemiGroupalApplicative

import cats.syntax.either._ // for catchOnly


object Intro extends App{
  /*
  In monad and Functor we are able sequence operations/computations
  but in case we fail in first example it breaks
  in cases like form we need to return all the error at once
  flatMap aren’t quite capable of capturing what we want because they make the assump􏰁on that each computa􏰁on is dependent on the previous
   */
  def parseInt(str: String): Either[String, Int] = Either.catchOnly[NumberFormatException](str.toInt).
    leftMap(_ => s"Couldn't read $str")
  val res1 = for {
    a <- parseInt("a")
    b <- parseInt("b")
    c <- parseInt("c")
  } yield (a + b + c)
  println(res1)
  // res1: scala.util.Either[String,Int] = Left(Couldn't read a)
  /*
  so only one error was returned
   */

}
