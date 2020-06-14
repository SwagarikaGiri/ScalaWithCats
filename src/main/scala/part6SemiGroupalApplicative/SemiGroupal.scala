package part6SemiGroupalApplicative
import cats.Semigroupal
import cats.instances.option._ //Semigroupal
import cats.syntax.apply._

/*
   Functor or monad construct makes an assumption that the current computation/function is dependent on the previous one
   So there comes SemiGroupal that extends Functor and Semigroup
   trait Semigroupal[F[_]]{
   def product[A,B](fa: F[A], fb: F[B]): F[(A, B)]
   }

 */
object SemiGroupal extends App{


  val res= Semigroupal[Option].product(Some(123), Some("abc"))
  println(res)
  val res1= Semigroupal[Option].product(Some(123),None)
  println(res1)
  // joinning three of more context
  val res2= Semigroupal.tuple3(Option(10),Option(20),Option(30))
  println(res2)
  val res3 =Semigroupal.map3(Option(1), Option(2), Option(3))(_ + _ + _)
  println(res3)

  println(Semigroupal.map2(Option(19), Option(0))(_ + _))
  // res6: Option[Int] = None

  /*
      There has also been beautiful syntax
   */
  
  println((Option(7),Option(7),Option(10)).tupled)
}
