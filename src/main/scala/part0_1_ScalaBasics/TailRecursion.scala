package part0_1_ScalaBasics
import scala.annotation.tailrec
object TailRecursion extends App{

  //Concatenation Greeting Problem Using Tail Recursion

  def greetingFunction(aSting:String,ntimes:Int):String={
    @tailrec
    def greetingHelper(accumulator:String,x:Int):String={
      if(x<1)
        accumulator
      else
        greetingHelper(accumulator+" "+aSting,x-1)
    }
    greetingHelper("",ntimes)
  }
  println(greetingFunction("Hello",10))

  // Fibbonnaci Series using Tail Recursion

  def fibbonnaciFunction(n:Int):Int={
    @tailrec
    def fibbonacciHelper(i:Int,last:Int,secondLast:Int):Int={
      if(i>=n)
        last
      else
        fibbonacciHelper(i+1,last+secondLast,last)
    }
    fibbonacciHelper(2,1,1)
  }
  println("Result of Fibonnaci Series Using Tail Recursion")
  println(fibbonnaciFunction(7))


  def factorialFunction(n:Int):Int={
    def factorialFunction(x:Int, accumulator:Int):Int={
      if(n<=1)
        accumulator
      else
        factorialFunction(x-1,x*accumulator)
    }
    factorialFunction(n,1)
  }


  def primeFunction(n:Int):Boolean={
    def primeHelper(t:Int, isStillPrime:Boolean):Boolean={
      if(!isStillPrime)
        false
      else if(t<=1)
        true
      else
        primeHelper(t-1,n%2!=0 && isStillPrime)
    }
    primeHelper(n/2,true)
  }

  println(primeFunction(2003))
  println(primeFunction(20))

}
