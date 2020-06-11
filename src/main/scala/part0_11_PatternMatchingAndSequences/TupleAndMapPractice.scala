package part0_11_PatternMatchingAndSequences

object TupleAndMapPractice extends App{

  /*
  finite ordered list
   */
  val aTuple = new Tuple2(2,"hello scala")
  println(aTuple._2)
  // Maps - keys -> values
  val aMap:Map[String,Int]=Map()
  val phonebook = Map(("Jim",555),"Daniel"->765)
  println(phonebook)


}
