package part0_11_PatternMatchingAndSequences

object AllPatterns extends App{

  // 1- Constants
  val x: Any = "Scala"
  val constants = x match{
    case 1 => "a number"
    case "Scala" => "The Scala"
    case true =>"The Truth"
    case AllPatterns => "A Singleton object"

  }
 /*
  2.1 Match everything wildcard
  */
  val matchAnything = x match{
    case _=>
  }

  /*
  2.2 Variable
   */


  val matchAVariable = x match{
    case something => s"I've found $something"

  }

  /*
   2.3 Tuple
   */
  val aTuple =(1,2)
  val matchATuple = aTuple match {
    case(1,1) => 2
    case(something,2)=>1
    case (_,_)=>6

  }
}
