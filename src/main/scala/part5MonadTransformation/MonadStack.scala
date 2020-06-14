package part5MonadTransformation
import cats.data.OptionT
import cats.instances.option._
import cats.instances.list._//Monad
import cats.syntax.applicative._//pure
import cats.instances.either._ // for Monad
object MonadStack extends App{

  type ListOption[A] = OptionT[List,A]
  type ErrorOr[A] = Either[String,A]
  type ErrorOrOption[A] = OptionT[ErrorOr,A]
  val a = 10.pure[ErrorOrOption]
  // a: ErrorOrOption[Int] = OptionT(Right(Some(10)))
  val b = 32.pure[ErrorOrOption]
  val c = 2.pure[ErrorOrOption]
  // b: ErrorOrOption[Int] = OptionT(Right(Some(32)))
  println(s"$a $b $c")
  // OptionT(Right(Some(10))) OptionT(Right(Some(32))) it is inside out
  /*
  if we see then option is inner most then Error then Option T
   */
  /*
  we know that optionT has its own flatMap and map functions
  lets try how it works

   */
  val d = a.flatMap(x=>b.flatMap(y=>c.map(z=>x+y+z)))
  println(d)
  //OptionT(Right(Some(10))) OptionT(Right(Some(32))) OptionT(Right(Some(2)))
  //OptionT(Right(Some(44)))



}
