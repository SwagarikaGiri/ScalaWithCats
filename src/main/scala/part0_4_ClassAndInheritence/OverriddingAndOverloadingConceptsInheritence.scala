package scalaIntroduction.part4ScalaClassInheritence

// key take ways
// we can stop over ridding
//1. using the keyword final
// using final on class prevent it from extending
// using keyword seal will make the extention valid in the file but not outside
object OverriddingAndOverloadingConceptsInheritence extends App {

  class Animal(val name:String,cType:String){
    val creatureType:String=cType
    val overidingVariable:String="Animal"
     def eat(): String = {
      s"nomnom"

    }
    //constructor overloading so Animal() or Animal("Domestic") both are valid
    def this(name:String)= this(name,"wild")
    def cries():String={
      s"HiHaHiHa"
    }

    def apply():String={
      s"The animal has name $name  and is of type $creatureType"
    }
  }



  // identifies both type of constructor also known as constructor overloading
  class Lion extends Animal("leo"){

  }

  class Dog extends Animal("doggy","Domestic"){

    // a val and member function can be overridden
    override val overidingVariable: String = "Dog"
    override def eat():String={
      println(super.eat())
      s"crumcrum"
    }

  }

  val leo = new Lion
  val doggy = new Dog

  println(leo())
  println(doggy())
  println(leo.overidingVariable)
  println(doggy.overidingVariable)
  println(doggy.eat())

}
