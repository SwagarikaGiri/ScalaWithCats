package part0_11_PatternMatchingAndSequences

import scala.util.Random

object PatternMatching extends App{


  val random = new Random
  val x = random.nextInt(10)
  println(x)

  val description = x match {
    case 1 => "the ONE"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else" // _ WILDCARD
  }
  println(description)
  // 1. Decompose values
  /*
  cases are matched in order
  if no cases match then there is a matching error
  Type of the PM expression ? Unified type of all the return types
  PM on sealed hierarchy
  Pattern matching is extremely useful using case classes
  sealed classes


   */
  case class Person(name:String, age:Int)
  val bob = Person("Bob",20)
  val greeting = bob match {
    case Person(n,a) if(a < 21) => s"Hi my name is $n and I am $a years old and >>>"
    case Person(n,a) => s"Hi my name is $n and I am $a years old"
    case _ => "I dont know who I am"

  }
  println(greeting)
  /*
  Lets deal with some pattern exercises
  trait Expr
  case class Number(n :Int) extends Expr
  case class Sum(e1:Expr,e2:Expr) extends Expr
  case Prod(e1:expr, e2:Expr) extends Expr


  Simple Function as PM
  takes an Expr => human readable format
  Sum(Num)



   */
  trait Expr
  case class Number(n :Int) extends Expr
  case class Sum(e1:Expr,e2:Expr) extends Expr
  case class Prod(e1:Expr, e2:Expr) extends Expr
 def show(e:Expr):String = e match{
   case Number(n) => s"$n"
   case Sum(e1,e2)=> show(e1)+" "+"+"+" "+show(e2)
   case Prod(e1,e2)=>{
     def maybeShowParentheses(exp:Expr)=exp match{
       case Prod(_,_)=>show(exp)
       case Number(_)=>show(exp)
       case _=> "(" +show(exp)+ ")"
     }
     maybeShowParentheses(e1)+ " + " + maybeShowParentheses(e2)
   }

 }

  println(show(Sum(Number(2),Number(3))))
}
