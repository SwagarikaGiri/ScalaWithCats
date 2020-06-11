package part0_4_ClassAndInheritence

abstract class MyList {
  def head:Int
  def tail:MyList
  def isEmpty:Boolean
  def add(element:Int):MyList
  //    def toString(myList:MyList):String


}


//Empty is Object and Class Bcoz Object are the SingleTon that can be initialized just once
object Empty extends MyList{
  def head:Int= throw new NoSuchElementException
  def tail:MyList = throw new NoSuchElementException
  def isEmpty:Boolean=true
  def add(element:Int):MyList=new CollectionList(element,Empty)
  //  def toString(myList:MyList):String

}
class CollectionList(h:Int,t:MyList) extends MyList{
  def head:Int=h
  def tail:MyList=t
  def isEmpty:Boolean=false
  def add(element:Int):MyList= new CollectionList(element,this)
  //  def toString(myList:MyList):String

}


// It is the runnable function as it extends App
object ListTester extends App{

  // empty is the object type hence no need to initialize
  val list = new CollectionList(1,Empty)
  println(list.add(5).head)
  println(list.head)

}

