package part0_1_ScalaBasics

object UnderstandTheLimitations extends App{
  // in this case a seperate stack is established
  def factorial(n:Int):Int={
    if(n<=1) 1
    else
    {
      println("For Computing The Factorial of N first we need factorial of"+n)
      var result=n*factorial(n-1)
      println("Factorial of "+ " "+n+" "+" is" + result)
      result
    }

  }
  //  println(factorial(20000))
  //Here we used a single stack and resued it
  def factorialNew(n:BigInt):BigInt={
    def factorialHelper(x:BigInt,accumulator:BigInt):BigInt={
      if(x<=1)
        accumulator
      else
        factorialHelper(x-1,x*accumulator)

    }
    factorialHelper(n,1)
  }
  println(factorialNew(20000))
}
