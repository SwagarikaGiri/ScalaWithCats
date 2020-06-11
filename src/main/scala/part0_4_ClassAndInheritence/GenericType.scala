package scalaIntroduction.part4ScalaClassInheritence

object GenericType extends App{
  //Initially we had to define the type if it is integer or it is String
  class MyList[A]
  val listOFInteger = new MyList[Int]
  val listOfString = new MyList[String]


  class Animal
  class Cat extends Animal
  class Dog extends Animal
  //Covariance  --> Cat is the type of animal so the list of cat is also the list of animal
  class CovariantList[+A]
  val animalList : CovariantList[Animal]= new CovariantList[Cat]

  //Invariant
  class InvariantList[A]
  val animalList2 : InvariantList[Animal]= new InvariantList[Animal]

  // There is another type Contravariant
  class ContravariantList[-A]
  val animalList4:ContravariantList[Cat] = new ContravariantList[Animal]


  // Trainer Type
  class Trainer[-A]
  val animalList3: Trainer[Cat] = new Trainer[Animal]




}
