package part0_5_OOPS_Concepts

abstract class MyListGeneric[+A]{
  def head: A
  def tail: MyListGeneric[A]
  def isEmpty:Boolean
  def add[B >: A](element:B):MyListGeneric[B]
  //    def toString(MyListGeneric:MyListGeneric):String
  def printElement:String

  override def toString: String ="["+printElement+"]"

  // add the new methods that are needed to complete the exercise those are map filter and flat map
  def map[B](transformer: MyTransformer[A,B]):MyListGeneric[B]
  //  def flatMap[B](transformer: MyTransformer[A,MyListGeneric[B]]):MyListGeneric[B]
  def filter(predicate: MyPredicate[A]):MyListGeneric[A]


}


//Empty is Object and Class Bcoz Object are the SingleTon that can be initialized just once
// The Issue here is with The Empty Type which is a object
// We should be able to say val listOfInteger = new MyList[Int] = Empty
// We should be able to say val listOfString = new MyList[Int] = String
// This is not possible with the Object Type in Scala as Object is the Singleton
/* So here the Nothing type comes to the rescue */

object EmptyGeneric extends MyListGeneric[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail:MyListGeneric[Nothing] = throw new NoSuchElementException
  def isEmpty:Boolean=true
  def add[ B >: Nothing](element:B):MyListGeneric[B]=new CollectionListGeneric(element,EmptyGeneric)

  def printElement: String = ""
  //  def toString(MyListGeneric:MyListGeneric):String
  override def map[B](transformer: MyTransformer[Nothing,B]):MyListGeneric[B]=EmptyGeneric
  //  override def flatMap[B](transformer: MyTransformer[Nothing,MyListGeneric[B]]):MyListGeneric[B]=EmptyGeneric
  override def filter(predicate: MyPredicate[Nothing]):MyListGeneric[Nothing]=EmptyGeneric

}
class CollectionListGeneric[+A](h:A,t:MyListGeneric[A]) extends MyListGeneric[A]{
  def head:A=h
  def tail:MyListGeneric[A]=t
  def isEmpty:Boolean=false
  def add[B >: A](element:B):MyListGeneric[B]= new CollectionListGeneric(element,this)

  override  def printElement: String = {
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
  def map[B](transformer: MyTransformer[A,B]):MyListGeneric[B]={
    new CollectionListGeneric[B](transformer.transform(h),t.map(transformer))
  }
  //    def flatMap[B](transformer: MyTransformer[A,MyListGeneric[B]]):MyListGeneric[B]={}

  /*
  Lets see how filter works
  [1,2,3].filter(n%2==0)
  =first element fail
  =[2,3].filter(n%2==0)
  =new Cons(2,[3].filter(n%2)==0)
  =new Cons(2,empty.filter(n%2)==0)
  =new Cons(2, Empty)
   */

  def filter(predicate: MyPredicate[A]):MyListGeneric[A]={
    if(predicate.helperMethod(h))
      new CollectionListGeneric[A](h,t.filter(predicate))
    else
      t.filter(predicate)

  }
  //  def toString(MyListGeneric:MyListGeneric):String

}

trait MyPredicate[-T]{
  def helperMethod(element:T):Boolean
}

trait MyTransformer[-A,B]{
  def transform(element:A):B
}
object ExerciseOnOOPsConcepts  extends App{
  // new list of Integer
  val listOfIntegers:MyListGeneric[Int] = new CollectionListGeneric[Int](1, new CollectionListGeneric[Int](2, new CollectionListGeneric[Int](5,EmptyGeneric)))
  println(listOfIntegers.toString)
  println(listOfIntegers.map(new MyTransformer[Int,Int] {
    override def transform(ele:Int):Int=ele*2
  }).toString)

  //lets see how the Filter works
  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def helperMethod(element: Int): Boolean = element%2==0
  }))

  // new list of String
  val listOfStrings:MyListGeneric[String] = new CollectionListGeneric[String]("Scaala",new CollectionListGeneric[String]("Java",new CollectionListGeneric[String]("Python",EmptyGeneric)))
  println(listOfStrings.toString)


}

