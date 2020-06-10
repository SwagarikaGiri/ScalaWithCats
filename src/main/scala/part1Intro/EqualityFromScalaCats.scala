package part1Intro
import cats.Eq
import cats.instances.int._

object EqualityFromScalaCats extends App{



  implicit val intInstance = Eq[Int]
  println(intInstance.eqv(89,90))

  import cats.syntax.eq._ // for commands === !=
  println(123 === 123)
  println(123 =!= 344)
}
