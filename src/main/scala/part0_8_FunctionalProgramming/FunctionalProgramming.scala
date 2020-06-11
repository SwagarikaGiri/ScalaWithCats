package part0_8_FunctionalProgramming

/*
ALL SCALA FUNCTIONS ARE OBJECTS
 */

object FunctionalProgramming extends App {
  // DREAM: use functions as first class element
  //Problem: OOPs JVM was made that way where everything is the instance of a class



  /*
  doubler which is the instance of the class can ve used like a function
  Function Type =
   */
  val doubler = new MyFunction[Int,Int] {
    override def apply(element: Int): Int = element*2
  }


  println(doubler(2))


  val stringToIntConvertor = new MyFunction[String,Int] {
    override def apply(element: String): Int = element.toInt
  }

  println(stringToIntConvertor("2")+4)

  /*
  Another Way is by using anonymous Functions
  Int,Int=>Int is a syntactic sugar for function2
   */

  val additionObject = new Function2[Int,Int,Int] {
    override def apply(v1: Int, v2: Int): Int = v1+v2
  }

  println(additionObject(7,8))
  //Sybtactic sugar formaat of Function 2 --> There are inbuild functional classes that we can
  //initialize using anonymous class
  val adder:((Int,Int)=>Int) = new Function2[Int,Int,Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
}

// abstract class
trait MyFunction[A,B]{
  def apply(element:A):B
}