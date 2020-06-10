package part3MonoidConceptsAndPractice
import cats.Monoid
import cats.instances.int._
import cats.syntax.semigroup._
/*
what is list is of type options
 */
object MonoidWithCats extends App{

  def addWithoutMonoid(list:List[Int]):Int={
    list.foldLeft(0)(_+_)
  }

  def addWithMonoid(list:List[Int]):Int={
    list.foldLeft(Monoid.empty[Int])(_|+|_)
  }

  val result1 = addWithoutMonoid(List(37,8,3,4,8))
  val result2 = addWithMonoid(List(67,7,8,9,4))
  println(s"Result : ${result1}")
  println(s"Result : ${result2}")

}
