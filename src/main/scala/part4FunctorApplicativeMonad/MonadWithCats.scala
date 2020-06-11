package part4FunctorApplicativeMonad
import cats.Monad
import cats.instances.option._
import cats.instances.list._

object MonadWithCats extends App{


  val option1 = Monad[Option].pure(3)
  println(option1)

  // use flat map on it we need to supply pure
  val option2 = Monad[Option].flatMap(option1)(x=>Some(x+2))
  println(option2)

  // on list
  val list1 =Monad[List].pure(1,2,3,4,5)
  println(list1)
  val list2 = Monad[List].flatMap(List(1,2,3,4,5))(x=>List(x , x+1))
  println(list2)

  val list = List(1,2,3,4)
  val list3 = Monad[List].flatMap(list)(x=>List(x,x+1))

}
