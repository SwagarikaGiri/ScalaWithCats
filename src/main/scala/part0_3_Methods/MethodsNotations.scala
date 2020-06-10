package part0_3_Methods

//Hands on with syntactic sugar methods that resemblance the NLP type functions

object MethodsNotations extends App{
    class Person(val name:String, val favouriteMovie:String){
      def likes(movie:String):Boolean={
        movie==favouriteMovie
      }

      def hangOutWith(person:Person):String={
        s"${this.name} is hanging out with ${person.name}"
      }

      def apply():String={
        s"Hi my name is $name  and  my favourite movie is $favouriteMovie"
      }


  }
  val marry = new Person("Mary","Inception")
  // normal format
  println(marry.likes("Inception"))
  //infix notation also called Syntactic Sugar
  println(marry likes "Inception")
  val tom = new Person("Tom","Beautiful Mind")
  println(marry.hangOutWith(tom))
  println(marry hangOutWith tom)
  // whenever a object is supplied with () then it searches for apply method
  println(marry())

}
