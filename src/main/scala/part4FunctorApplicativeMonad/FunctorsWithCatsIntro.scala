package part4FunctorApplicativeMonad
import cats.instances.function._ //For Functor
import cats.syntax.functor._ // for map
/*
Functor is the class that encapsulates sequence of operations/computations
 */
object FunctorsWithCatsIntro extends App{


  val func1:Int => Double=
    (x:Int)=>x.toDouble


  val func2:Double=>Double=
    (y:Double)=> y * 2
  val res=(func1 map func2)(1)
  println(res)
  val res1=(func1 andThen func2)(1)
  println(res1)

  val res3=func2(func1(1))
  println(res3)

  val func =
    ((x: Int) => x.toDouble).
      map(x => x + 1).
      map(x => x * 2).
      map(x => s"$x" + "!")
  println(func(123))


}
