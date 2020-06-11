package part0_4_ClassAndInheritence

object AnonymousClasses extends App{

  abstract class Animal{
    def eat:Unit
  }

  // this is a anonymous class it allows you to instantiate the abstract class like Animal
  val dog:Animal = new Animal{
    override def eat: Unit = println("Dog eats meat and bone")
  }

  println(dog.eat)
}