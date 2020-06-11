package part0_9_AnonymousFunctions

object AnonymousFunctionPractice extends App{
  // traditional way of functional programming
  /*
  Issue with it is that it is still the tradional objected oriented way
   */
  val doubler = new Function[Int,Int] {
    override def apply(v1: Int): Int = v1*2
  }

  /*
  This and the above functions are the same
  this is called LAMBDA FUNCTION
   */
  val doublerF: Int => Int = (x:Int)=>x*2
  val doublerF2 : Int => Int = x => x*2
  /*
  Lets test all the codes
   */
  println(doubler(10))
  println(doublerF(10))
  println(doublerF2(10))

  /*
  When there are more than one input parameters it is necessary that we put them
  in the parenthesis
   */
 val adder:(Int,Int)=>Int=(x,y)=>x+y
  println(adder(10,6))

  /*
  Work with no argument lambda
  IMPORTANT: IT IS VERY IMPORTANT TO CALL LAMBDA FUNCTIONS WITH ()
   */

  val doSomething:()=>Int=()=>10
  // it return instance of the object
  println(doSomething)
  // it returns the actual value
  println(doSomething())
  /*
  CURLY BRACES WITH LAMBDA
   */

  val stringToIntRepresentation={
    (str:String)=>str.toInt
  }
  println(stringToIntRepresentation("99750"))
  /*
  More syntactis sugar notations
   */
  val niceIncrementer:(Int) => Int = _ + 1

  val niceAdder: (Int , Int) => Int = _ + _

  println(niceIncrementer(7))
  println(niceAdder(8,9))

  /*
  LAMBDA VERSION OF SUPPER ADDER
   */
  val supperAdderLambda= (x:Int) => (y:Int) => x+y
  println(supperAdderLambda(8)(9))

}
