package scalaIntroduction.part4ScalaClassInheritence


// could have used def main(args:Array[String])
object InheritenceBasics extends App{

  class Animal{
    protected def eat():String={
      s"nomnom"

    }

  }

  class Cat extends Animal{
    def cries():Unit={
      println(eat())
      println("Meow Meow")
    }
  }
  val kitty = new Cat

  println(kitty.cries())
}
