package part2Semigroups
/*
 Semi-group is a Set theory feature with Set and Operator
 Here the property we need to take into account is associativity
 It differs from monoid as it does not have empty element
 property
 */

/*
 In the below code we have three methods and all of them are same
 Hence there is a possiblity of refactoring the codes
 so that a same interface can be reused
 */
object SemiGroupUsingScala extends App with Data {

def addMoney(a:Money,b:Money):Money={
  Money((a.dollars + b.dollars)+(a.cents+b.cents)/100,
    (a.cents+b.cents)%100)}

  def creditSalary(balance:Map[String,Money],salaries:Map[String,Money]) :
  Map[String,Money]={
    balance.foldLeft(salaries){
      case (acc,(name,money))=>
        acc + (name -> acc.get(name).fold(money)(addMoney(_,money)))
    }
  }


  def addMarbles(balances:Map[String,Int],winning:Map[String,Int]):Map[String,Int]={
    balances.foldLeft(winning){
      case (acc,(name,marble))=>
        acc + (name -> acc.get(name).fold(marble)(_ + marble))
    }
  }

  println(s"Credit salary ${creditSalary(balances,salaries)}")
  println(s"Marbles ${addMarbles(marbles,won)}")
}
