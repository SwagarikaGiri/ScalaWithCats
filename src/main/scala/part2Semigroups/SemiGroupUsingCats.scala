package part2Semigroups
import cats.Semigroup
object SemiGroupUsingCats extends App with Data{

  def addMoney(a:Money,b:Money):Money={
    Money((a.dollars + b.dollars)+(a.cents+b.cents)/100,
      (a.cents+b.cents)%100)
  }
  import cats.instances.int._
  import cats.instances.map._
  implicit val addMoneyInstance = new Semigroup[Money] {
    override def combine(x: Money, y: Money): Money = addMoney(x, y)
  }

  def add[A:Semigroup](a:A,b:A)(implicit semigroup:Semigroup[A]):A={
    semigroup.combine(a,b)
  }
  println(s"Credit salary ${add(balances,salaries)}")
  println(s"Marbles ${add(marbles,won)}")

}
