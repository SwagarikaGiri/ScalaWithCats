package part1Intro

object JsonWriterIntroToTypeClass extends App {


  /*
  type class
   */
  trait JsonWriter[A] {
    def write(value: A): String
  }

  case class Person(name:String, age:Int )

  /*
    we pack it in a single package
    object and we need to
    define every instance as implicit
    to include them in the global scope
    they are not generic but has the actual type
    it implements the abstract methods
   */
  object JsonInstances{
    implicit val personInstance= new JsonWriter[Person] {
      override def write(value: Person): String = s"${value.name} is ${value.age} years old"
    }

    implicit val stringInstance = new JsonWriter[String] {
      override def write(value: String): String = s"Hi this is ${value}"
    }
  }
/*
   Now we need the interfaces
   There are two type of interfaces first one is
   Interface format and other one is Syntax format
 */

  object JsonInterface{
    def toJson[T](value:T)(implicit jsonObj:JsonWriter[T])={
      jsonObj.write(value)
    }
  }

  import JsonInstances._
println(JsonInterface.toJson(Person("Swagarika",25)))


  /*
   beautiful syntax representation
   */

  implicit class JsonSyntax[T](value:T){
    def toJson(implicit jsonObject:JsonWriter[T])={
      jsonObject.write(value)
    }
  }
 println((Person("Swagarika",25).toJson))
}
