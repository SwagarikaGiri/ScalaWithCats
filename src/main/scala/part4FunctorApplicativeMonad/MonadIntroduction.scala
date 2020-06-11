package part4FunctorApplicativeMonad
import cats.instances.int._
import scala.util.Try
/*
Monad is everything that has a constructor and flatMap
Functor is abstract class for sequencing computations
Monoid is the mechanism for sequencing computations
 */
object MonadIntroduction extends App{
  def parseInt(str: String):Option[Int]={
    Try(str.toInt).toOption

  }

  def divide(a:Int,b:Int):Option[Int]={
    if(b==0) None
    else Some(a/b)
  }

  def stringDivider(aStr:String,bStr:String):Option[Int]=
    parseInt(aStr).flatMap{ aNum =>
      parseInt(bStr).flatMap{ bNum =>
        divide(aNum,bNum)

      }

  }

  println(stringDivider("6","3"))
  println(stringDivider("Foo","7"))

  /*
  The cases we have flatMap and Map then we can use for Comprehension
   */
  def stringDivider2(aStr:String,bStr:String):Option[Int]={
    for{
      aNum <- parseInt(aStr)
      bNum <- parseInt(bStr)
      ans  <- divide(aNum,bNum)
    }yield(ans)
  }
  println(stringDivider2("6","3"))
  println(stringDivider2("Foo","7"))

}
