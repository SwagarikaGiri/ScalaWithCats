package part3MonoidConceptsAndPractice
/*
Monoid have closure , associative property and identity element
all monoid are semi groups
ex: For multiplication 1 is the identity elements
for addition 0 is the identity element
for concatenation "" is the identity element
 */
object IntroToMonoid extends App{


 trait Monoid[T]{
   def combine( a: T , b: T ): T
   def empty:T
 }
 def associativeLaw[T](x: T, y:T, z:T )(implicit M: Monoid[T]):Boolean={
   (M.combine(x,M.combine(y,z)))== (M.combine(M.combine(x,y),z))
 }
  def identityLaw[T](x:T)(implicit M:Monoid[T]): Boolean={
    ((M.combine(x,M.empty)==x) && (M.combine(M.empty,x))==x)
  }

  object Monoidinstance{
    implicit val intInstance = new Monoid[Int] {
      override def combine(a: Int, b: Int): Int = a + b

      override def empty: Int = 0
    }

    implicit val stringInstance = new Monoid[String]{
      override def combine(a: String, b: String): String = a + b

      override def empty: String = ""
    }



  }
  import Monoidinstance._
  val result1 = associativeLaw(2,3,6)
  val result2 = identityLaw(5)
  println(result1==true)
  println(result2==true)
}
