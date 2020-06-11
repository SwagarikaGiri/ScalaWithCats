package part0_6_ExceptionalHandling

/*
1 . first need to crash the program with OutOfMemoryError
2. Crash Stack over flow method
3. pocket calculator
  -add
  -subtract
  -multiply
  -divide
  throws
  -OverFlowException if add(x,y) exceeds Int.MAX_VALUE
  -UnderFlowException if subtract exceeds Int.MIN_VALUE
  -MathCalculationError if we try to divide bby 0
 */
object ExerciseForExceptionalHandling extends App{

  //OutOfMemoryException
  try
    {
      val a = Array.range(0,1234567890).view
    }
  catch{
    case e:OutOfMemoryError=>println("We ran into OutOfMemoryException")
  }

  //StackOverflowException
  try{
    val n:Int=20000
    var result:Int=0
     def fibonnaci(n:Int):Int={
       if(n<=1)
         1
       else
         n*fibonnaci(n-1)
     }
    result=fibonnaci(n)
    println(result)
  }
  catch
    {
      case e:StackOverflowError=>println("We ran into stackoverflow error")
    }

  class MaxValueException(s:String) extends Exception(s){}
  class MinValueException(s:String) extends Exception(s){}
  class MathCalculationError(s:String) extends Exception(s){}

  // we need to define a pocket calculator with add , subtract, multiplication and division
  class Calculator(val x:Int,val y:Int){

    @throws(classOf[MaxValueException])
    def add:Int=x+y
    @throws(classOf[MinValueException])
    def sub:Int=x-y
    @throws(classOf[MathCalculationError])
    def multi:Int=x*y

    def div:Int= {
      if(y==0)
      throw new MathCalculationError("Math Calculation Error")
    else
    x/y}

  }


  try{
    val pair:Calculator= new Calculator(1999999999,0)
    println(pair.add)
    println(pair.sub)
    println(pair.multi)
    println(pair.div)

  }
  catch
    {
      case a:MaxValueException=>println("Max value Exception have occurred")
      case b:MinValueException=>println("Min value Exception have occurred")
      case c:MathCalculationError=>println("Math Calculation Error Has Occurred")
    }

}
