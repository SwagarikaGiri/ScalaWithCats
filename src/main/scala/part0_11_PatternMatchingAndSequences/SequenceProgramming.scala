package part0_11_PatternMatchingAndSequences

object SequenceProgramming extends App{

  val aSequence = Seq(1,2,3,4)
  println(aSequence)
  /*
  seq.reverse
  seq(2)
  seq ++ seq()
  seq.sorted
   */

  //ranges
  val aRange : Seq[Int] = 1 to 10
  (1 to 10).foreach(e=>println("hi"+e))

  /*
  append operator :: is the operator
   */
 val aList =List(1,2,3)
  val prepend = 67::aList

  val apple5 = List.fill(5)("apples")
  println(apple5)

  /*
  Array concepts
   */

  val numbers = Array(1,2,3,4)
  val treeElements = Array.ofDim[Int](3)
  println(treeElements.mkString(" "))
  treeElements.foreach(e=>println("hi"))

  /*
  Vector - Immutable
   */

  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  /*
  Vectors-depth of tree is small vs List - For first element/tail element
  Vector is faster than List hence it is default notation
  -
   */

}
