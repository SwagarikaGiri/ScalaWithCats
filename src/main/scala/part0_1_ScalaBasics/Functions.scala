package part0_1_ScalaBasics

object Functions extends App{

  // Name Age Function
  def ageNameFunction(age : Int, name:String):String ={
    "Hi my name is"+" "+name+ " "+ "and my age is" + " "+age.toString
  }

  println(ageNameFunction(25, "Swagarika"))

  // Factorial

  def factorial(n : Int):Int={
    if(n==2||n==1)
      n
    else
      n*factorial(n-1)

  }

  println(factorial(10))

  // Fibbonnaci series n th fibbonnaci no
  def fibbonacci(n:Int):Int={
    if(n==1 ||n==2)
      1
    else
      fibbonacci(n-1)+fibbonacci(n-2)
  }
  println(fibbonacci(5))

  // Prime number
  def primeNumber(n:Int):Boolean={
    def isPrime(t:Int):Boolean={
      if(t==1) true
      else n%t!=0 && isPrime(t-1)
    }
    isPrime(n/2)
  }

  println(primeNumber(5))

}
