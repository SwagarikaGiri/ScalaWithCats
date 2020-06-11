package part0_4_ClassAndInheritence

abstract class MyListGeneric[+A]{
  def head: A
  def tail: MyListGeneric[A]
  def isEmpty:Boolean
  def add[B >: A](element:B):MyListGeneric[B]
  //    def toString(MyListGeneric:MyListGeneric):String
  def printElement:String

  override def toString: String ="["+printElement+"]"


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

}
class CollectionListGeneric[+A](h:A,t:MyListGeneric[A]) extends MyListGeneric[A]{
  def head:A=h
  def tail:MyListGeneric[A]=t
  def isEmpty:Boolean=false
  def add[B >: A](element:B):MyListGeneric[B]= new CollectionListGeneric(element,this)

  override  def printElement: String = {
    if(isEmpty)
      s" $h"
    else
      s"$h"+""+t.printElement
  }
  //  def toString(MyListGeneric:MyListGeneric):String

}


// It is the runnable function as it extends App
object ListTesterGeneric extends App{

  // empty is the object type hence no need to initialize
  val list = new CollectionListGeneric(1,new CollectionListGeneric(5,new CollectionListGeneric(9,EmptyGeneric)))
  println(list.add(5).head)
  println(list.head)
  println(list.toString)

  // new list of Integer
  val listOfIntegers:MyListGeneric[Int] = new CollectionListGeneric[Int](1, new CollectionListGeneric[Int](3, new CollectionListGeneric[Int](5,EmptyGeneric)))
  println(listOfIntegers.toString)

  // new list of String
  val listOfStrings:MyListGeneric[String] = new CollectionListGeneric[String]("Scaala",new CollectionListGeneric[String]("Java",new CollectionListGeneric[String]("Python",EmptyGeneric)))
  println(listOfStrings.toString)

}

