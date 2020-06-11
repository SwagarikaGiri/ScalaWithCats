package part0_10_HOFAndCurriedFunctions

object MapFlatMapFilter extends App{

  val list = List(1,2,37,8,4,5,6,9)
  val list2=List('a','b','c')
  println(list)
  println(list.head)
  println(list.tail)
//  println(list.map(x=>x+"is a number" ))
  println(list.filter(_%2==0))
  //flatmap
  val toPair = (x:Int) => List(x,x+1)
  println(list.flatMap(toPair))
  /*
    Print all combinations between two list
    [1,2,3] and [a,b,c]
    if we have two loops flatmap map
    if we have three loops flatmap flatmap map

   */
  val combine = list.flatMap(n=>list2.map(c=>" "+c + n))
  println(combine)
  /*
  forEach
   */
  list.foreach(println)

  /*
  For - Comprehension

   */
  val forComprehension = for{
    n  <- list
    c  <- list2
  }yield " " + c + n + " "

  println(forComprehension)
  // syntax overload
  /*
   map(f: A->B)=>MyList[B]
   filter(p:A=>Boolean)=>MyList[B]
   flatMap(f:A--> MyList[B]) => MyList[B]
   */

  /*
  MyList supports for comprehension
   in case of list we need
  a small collection of at most one element
   */

}
