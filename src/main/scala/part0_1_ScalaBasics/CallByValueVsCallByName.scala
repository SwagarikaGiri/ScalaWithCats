package part0_1_ScalaBasics


object CallByValueVsCallByName extends App{

  //Call By Value First Evaluates the Expression  then uses it whenever necessary
  def callByValue(x:Long):Unit={
    println("The call by value is"+x)
    println("The call by value is"+x)
  }
  def callByName(x: => Long):Unit={
    println("The call by name is"+x)
    println("The call by name is"+x)
  }

  println(callByValue(System.nanoTime))
  println(callByName(System.nanoTime))


  //Call By Name Evaluates the expression only when it is required

}
