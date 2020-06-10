package part2Semigroups


case class Money(dollars: Int, cents: Int)

trait Data {
  // money
  val balance: Money = Money(987, 85)
  val salary: Money = Money(834, 78)
  val balances: Map[String, Money] = Map(
    "John" -> Money(987, 85),
    "Sara" -> Money(1234, 98)
  )
  val salaries: Map[String, Money] = Map(
    "Sara" -> Money(200, 90),
    "Mo" -> Money(4987,43)
  )

  // and marbles
  val marbles: Map[String, Int] = Map(
    "John" -> 6,
    "Sara" -> 9
  )
  val won: Map[String, Int] = Map(
    "Sara" -> 2,
    "Mo" -> 5
  )
}