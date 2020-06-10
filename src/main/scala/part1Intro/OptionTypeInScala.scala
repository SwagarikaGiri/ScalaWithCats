package part1Intro
/*
 Option[T] is a container that return Some(T) or None
 */
object OptionTypeInScala extends App{

  val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

  println("capitals.get( \"France\" ) : " +  capitals.get( "France" ))
  println("capitals.get( \"India\" ) : " +  capitals.get( "India" ))

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }
  println("capitals.get( \"France\" ) : " +  show(capitals.get( "France" )))
  println("capitals.get( \"India\" ) : " +  show(capitals.get( "India" )))


  val a:Option[Int] = Some(5)
  val b:Option[Int] = None

  println("a.isEmpty: " + a.isEmpty )
  println("b.isEmpty: " + b.isEmpty )
}

