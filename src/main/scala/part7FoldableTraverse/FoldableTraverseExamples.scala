package part7FoldableTraverse
import cats.Foldable
import cats.instances.list._ // for Foldable
import cats.Eval

/*
Since foldRight is not stack safe hence we use Eval in its defination
 */
object FoldableTraverseExamples extends App{
  val list = List(1,2,3,4,5)

  val res = Foldable[List].foldLeft(list,0)(_+_)
  println(res)

  def bigData = (1 to 100000).toStream
  import cats.instances.stream._ // for Foldable
  val eval: Eval[Long] =
    Foldable[Stream].
      foldRight(bigData, Eval.now(0L)) { (num, eval) =>
        eval.map(_ + num)
      }
  eval.value


}
