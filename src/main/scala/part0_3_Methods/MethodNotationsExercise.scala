package part0_3_Methods

import scala.language.postfixOps

object MethodNotationsExercise extends App{

  class Person(val name:String,val age:Int){

//    var nickname:String
//

    def +(nickname:String):Person={
      new Person(s"$name the $nickname",age)
    }

    def apply():String={
      s"Hi my name is $name and my age is $age"
    }

    def apply(times:Int):String={
      s"$name is $age for $times times"

    }
    def unary_+ :Person={
      new Person(s"$name",age+1)

    }

    def learns(language:String) = s"$name learns $language"


    def learnsScala = this learns "Scala"



  }

  val marry=new Person("Marry",56)
  println((marry + "rockstar")())
//  val tom = marry + "the rockstar"
  println((+(+marry))())
  // postfix notation
  println(marry learnsScala)
  println(marry(2))


}
