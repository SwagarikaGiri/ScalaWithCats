
import cats.Show


object IntroCatExample extends App{
  /*
  The Class have to be case class
  case class are by default constants
   */
  case class Cat(name:String, age:Int, color:String)
  /*
  There is a generic abstract trait Show  like Printable class
   */

  object ShowInstance
  {
    implicit val catInstance = new Show[Cat]{
      override def show(t: Cat): String = s"${t.name} ${t.age} ${t.color} "
    }
  }
  import ShowInstance._





  implicit class ShowSyntax[T](value:T){
    def show(implicit s:Show[T]):String=s.show(value)
  }
  println(Cat("Kitten",25,"white").show)

}
