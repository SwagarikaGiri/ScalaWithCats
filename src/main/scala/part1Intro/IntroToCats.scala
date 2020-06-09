package part1Intro
import cats.Show
import cats.instances.int._
import cats.instances.string._
object IntroToCats extends App{
  val showInt = Show[Int]
  val showString = Show[String]
  println(showInt.show(789999))
  println(showString.show("Swagarika"))
  /*
  does scala has something like the beautiful syntax
   */


  import cats.syntax.all._
  println("Rushikesh".show)

}
