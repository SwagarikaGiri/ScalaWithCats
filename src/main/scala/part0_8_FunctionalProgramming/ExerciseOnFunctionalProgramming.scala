package part0_8_FunctionalProgramming

/*
1 . a function that takes two strings and concatenate it
2. MyListImplemtation MyPredicate and Transformer in Functional style
    - We convert Tranformer Function1 A=>B type and we use Predicate A=>Boolean Type
    -Another important concept is HOF(map, filter)
    - HOF receive another function as parameter
    -Or Return Function - They consider Function as first level argument
3. Function that takes the argument as int and returns another function that takes an int and return another Int

    - Whats the type of the function
    -How do we actually do it

 */
object ExerciseOnFunctionalProgramming extends App {


  /*
    Example 1- a function that takes two strings and concatenate it
   */

  val adder:((String,String)=>String)= new Function2[String,String,String] {
    override def apply(v1: String, v2: String): String = v1 + "  "+v2
  }

  println(adder("Hello","World"))

  /*
  Example 2 - MyList Implementation and Convert MyPredicate and Trnasformer in
  Functional way
   */

  abstract class MyListGeneric[+A]{
    def head: A
    def tail: MyListGeneric[A]
    def isEmpty:Boolean
    def add[B >: A](element:B):MyListGeneric[B]
    //    def toString(MyListGeneric:MyListGeneric):String
    def printElement:String

    override def toString: String ="["+printElement+"]"


    // add the new methods that are needed to complete the exercise those are map filter and flat map
    def map[B](transformer: A=>B):MyListGeneric[B]
    //  def flatMap[B](transformer: MyTransformer[A,MyListGeneric[B]]):MyListGeneric[B]
    def filter(predicate: A=>Boolean):MyListGeneric[A]


  }

  object EmptyGeneric extends MyListGeneric[Nothing]{
    def head: Nothing = throw new NoSuchElementException
    def tail:MyListGeneric[Nothing] = throw new NoSuchElementException
    def isEmpty:Boolean=true
    def add[ B >: Nothing](element:B):MyListGeneric[B]=new CollectionListGeneric(element,EmptyGeneric)

    def printElement: String = ""
    //  def toString(MyListGeneric:MyListGeneric):String
    override def map[B](transformer: Nothing=>B):MyListGeneric[B]=EmptyGeneric
    //  override def flatMap[B](transformer: MyTransformer[Nothing,MyListGeneric[B]]):MyListGeneric[B]=EmptyGeneric
    override def filter(predicate: Nothing=>Boolean):MyListGeneric[Nothing]=EmptyGeneric

  }
  class CollectionListGeneric[+A](h:A,t:MyListGeneric[A]) extends MyListGeneric[A] {
    def head: A = h

    def tail: MyListGeneric[A] = t

    def isEmpty: Boolean = false

    def add[B >: A](element: B): MyListGeneric[B] = new CollectionListGeneric(element, this)

    override def printElement: String = {
      if (isEmpty)
        s" $h"
      else
        s"$h" + " " + t.printElement
    }

    /*
    Let us see how the map works
    [1, 2,3].map(n*2)
       = new Cons(2,[2,3].map(n*2))
       = new Cons(2, new Cons(4,[3].map(n*2)))
       = new Cons(2, new Cons(4,new Cons(6,Empty.map()))
     */
    def map[B](transformer: A => B): MyListGeneric[B] = {
      new CollectionListGeneric[B](transformer(h), t.map(transformer))
    }
    def filter(predicate: A=>Boolean):MyListGeneric[A]={
      if(predicate(h))
        new CollectionListGeneric[A](h,t.filter(predicate))
      else
        t.filter(predicate)

    }
  }


  val listOfIntegers:MyListGeneric[Int] = new CollectionListGeneric[Int](1, new CollectionListGeneric[Int](2, new CollectionListGeneric[Int](5,EmptyGeneric)))
  println(listOfIntegers.toString)
  println(listOfIntegers.map(new Function1[Int,Int] {
    override def apply(ele:Int):Int=ele*2
  }).toString)


  //lets see how the Filter works
  println(listOfIntegers.filter(new Function1[Int,Boolean] {
    override def apply(element: Int): Boolean = element%2==0
  }))

  // new list of String
  val listOfStrings:MyListGeneric[String] = new CollectionListGeneric[String]("Scaala",new CollectionListGeneric[String]("Java",new CollectionListGeneric[String]("Python",EmptyGeneric)))
  println(listOfStrings.toString)




  /*
  Example 3: Function1[Int, Function1[Int,Int]] is supposed to be the final solution
  Higher Order Function
   */
  val supperAdder:Function1[Int, Function1[Int,Int]] = new Function[Int,Function1[Int,Int]] {
    override def apply(v1: Int): Function1[Int,Int]  = new Function[Int,Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }


  val subAdder = supperAdder(3)
  println(subAdder(7))
  println(supperAdder(8)(12)) // curried function
}
