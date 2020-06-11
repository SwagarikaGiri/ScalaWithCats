package part0_10_HOFAndCurriedFunctions

object HigherOrderFunctionAndCurriedFunctionsPractice extends App{


  //take or give function as the parameter
 // val nTimes (f, n, x) f is the function n is the no of time and x is the subject
// nTimes(f,3,x) => f(f(f(x)))

  def nTimes(f:Int=>Int,n:Int,x:Int):Int={
    if(n<=0)
      x
    else
      nTimes(f,n-1,f(x))
  }
  val plusOne = (x:Int) => x + 1
  println(nTimes(plusOne,10,1))

  /*
  There is another way where we will keep the value of x for later
  i.e we will implement f(f(f(something)))
  ntb(f,n)=x=>f(f(f(x)))
  lets see
   */
  def nTimesBetter(f:Int=>Int,n:Int):(Int=>Int)={
    if(n<=0)
      (x:Int)=>x
    else
      (x:Int)=>nTimesBetter(f,n-1)(f(x))

  }
  val plus10 = nTimesBetter(plusOne,10)
  println(plus10(1))

  /*
  nTimesBetter(f,n-1)(f(x)) curried functions
  */

  /*
  Functions with mulitple parameters lists
   */
  def curriedFormatter(c:String)(x:Double):String=c.format(x)

  val standartFormat: (Double=>String)=curriedFormatter("%4.2f")
  val preciseFormat: (Double=>String)=curriedFormatter("%4.10f")

  println(standartFormat(Math.PI))
  println(preciseFormat(Math.PI))

}
