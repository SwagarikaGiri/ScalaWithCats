package part2Semigroups

object SemiGroupWithAbstractClass extends App with Data{

  def addMoney(a:Money,b:Money):Money={
    Money((a.dollars + b.dollars)+(a.cents+b.cents)/100,
      (a.cents+b.cents)%100)}

  trait Addable[T]{
    def add(a:T,b:T):T
  }
  object AddableInstance{
    implicit val addInt = new Addable[Int] {
      override def add(a: Int, b: Int): Int =  a+b
    }
    implicit val addMoneyObj = new Addable[Money] {
      override def add(a: Money, b: Money): Money = addMoney(a,b)
    }
  }
import AddableInstance._
  def addMaps[K,V](balances:Map[K,V],newMap:Map[K,V])(implicit addable:Addable[V]):Map[K,V]={
    balances.foldLeft(newMap){
      case (acc,(k,v))=>
        {
          acc +(k->acc.get(k).fold(v)(addable.add(_,v)))
        }
    }
  }

  println(s"Credit salary ${addMaps(balances,salaries)}")
  println(s"Marbles ${addMaps(marbles,won)}")
}
