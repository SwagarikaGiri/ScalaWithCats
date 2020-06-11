package part4FunctorApplicativeMonad


import scala.language.higherKinds
import cats.Functor
import cats.instances.function._
// for Functor
import cats.syntax.functor._
// for map
import cats.instances.option._
import cats.instances.list._
/*
Functor law-
Identity Function- Identity function is saame as doing nothing
Composition Law- Mapping with two functions is same as maapping with f and then

 */
object FunctorLaws extends App{

  val list1 = List(1,2,3,4,5)
  val list2 = Functor[List].map(list1)(_*2)
  println(list2)

  val option1 = Option(234)
  val option2 = Functor[Option].map(option1)(_.toString)
  println(option2)

  /*
  Functor also has lift method which converts function of type a--> b
  then we can apply functor on those fuction

   */

  val func = (x:Int) => x + 1
  val functorFunc = Functor[Option].lift(func)
  println(functorFunc(Option(8)))

}
