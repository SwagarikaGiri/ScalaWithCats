package part0_6_ExceptionalHandling

object ExceptionalHandling extends App{
  val x:String = null
  // this will crash as there is no length for null string
//  println(x.length)
  // so we need to throw and catch exception



//  val aWeirdValue = throw new NullPointerException


  // throwable classes extends the Throwable class
  //Exception and error are the major throwable subtype
  //error are more serious
  // Catch the exception
  def getInt(withException:Boolean): Int = {
    if(withException) throw new RuntimeException("No Int For U!")
    else 42


  }

  try{
    getInt(true)
  }
  catch{
    case e:RuntimeException => println("caught a runtime exception")
  }
  finally
    {
    //Code that will get executed no matter what
      //finally block is optional
      // finally block does not influence the return type of this try catch finally block
      //use finally for side effects like logging
      println("Code Finally")
    }


  //How do we define the Exception of my own


}

