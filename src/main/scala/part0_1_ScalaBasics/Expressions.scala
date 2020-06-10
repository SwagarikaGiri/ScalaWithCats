package part0_1_ScalaBasics

object Expressions extends App{
  //in scala everything is an expression
  // if is an expression
  println(if(true)5 else 3)
  var i=0
  // it is called unit
  var aWhile = while(i<10)
  {
    println(i)
    i+=1
  }
  // this is a issue as in aWhile there is return it is Instruction and not just the Expression and everything in Scala is an expression
  println(aWhile)

  // there is another important take away that is Code Blocks

  val aCodeBlock = {
    val a=5;
    val b=8;
    if(a>b)a else b
  }
  println(aCodeBlock)

}
