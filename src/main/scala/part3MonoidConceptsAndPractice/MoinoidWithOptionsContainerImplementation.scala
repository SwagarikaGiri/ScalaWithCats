package part3MonoidConceptsAndPractice
import cats.instances.int._
import cats.Monoid
import cats.syntax.semigroup._
import cats.instances.option._
object MoinoidWithOptionsContainerImplementation extends App{

 def addWithoutMonoid(list : List[Option[Int]]) : Option[Int] ={

   list.foldLeft (Option(0) ) {
     case (acc, value) => acc.map(i => value.fold(i)(_+i))
 }
 }
 def addWithMonoid(list : List[Option[Int]]): Option[Int] ={
   list.foldLeft (Monoid.empty[Option[Int]]) {
     (_|+|_)
   }
 }

  println(addWithMonoid(List(Some(67),Some(88),Some(7))))
  println(addWithoutMonoid(List(Some(67),Some(88),Some(7))))
}
