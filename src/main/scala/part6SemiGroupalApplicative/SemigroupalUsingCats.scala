package part6SemiGroupalApplicative
import cats.Monoid
import cats.instances.list._
import cats.syntax.apply._
import cats.instances.string._
import cats.instances.int._
import cats.instances.invariant._
import cats.syntax.semigroup._ // for |+|
object SemigroupalUsingCats extends App{

  case class Cat( name: String, yearOfBirth: Int, favouriteFood: List[String])

  val tupleToCat:( String,  Int, List[String])=> Cat= Cat.apply _

  val catToTuple:Cat=>( String,  Int, List[String])=cat=> (cat.name,cat.yearOfBirth,cat.favouriteFood)


  implicit val catMonoid:Monoid[Cat]=(
    Monoid[String],
    Monoid[Int],
    Monoid[List[String]]
  ).imapN(tupleToCat)(catToTuple)


  val garfield = Cat("Garfield", 1978, List("Lasagne"))
  val heathcliff = Cat("Heathcliff", 1988, List("Junk Food"))
 println( garfield |+| heathcliff)





}
