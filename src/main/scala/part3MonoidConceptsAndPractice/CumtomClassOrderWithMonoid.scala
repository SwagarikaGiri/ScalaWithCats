package part3MonoidConceptsAndPractice
import cats.Monoid
import cats.instances.int._
import cats.instances.double._
import cats.syntax.semigroup._
object CumtomClassOrderWithMonoid extends App{

  case class Order(price:Double, quality:Int)


  implicit val orderMonoid = new Monoid[Order]{
    override def combine(x: Order, y: Order): Order =
      Order((x.price |+| y.price),(x.quality |+| y.quality))

    override def empty: Order = Order(0.0,0)


  }

  def addOrders(list:List[Order])(implicit M:Monoid[Order]):Order={
    list.foldLeft(M.empty)(M.combine(_,_))
  }

  val orders = List(Order(34,2),Order(12,3),Order(90,4))
  val result = addOrders(orders)
  println(result)

}
