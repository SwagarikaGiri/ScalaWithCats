package part1Intro
import cats.Show
object CatExampleUsingCats extends App {

  case class Cat(name:String, color:String)
  object ShowInstances{
    implicit val catShowInstance = new Show[Cat] {
      override def show(t: Cat): String = s"Cats name is ${t.name} cats color is ${t.color}"
    }
  }


  import ShowInstances._
  import cats.syntax.show._

  println(Cat("Hazel","Hazel").show)




}
