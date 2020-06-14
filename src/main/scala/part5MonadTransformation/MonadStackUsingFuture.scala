package part5MonadTransformation
import scala.concurrent.Future
import cats.data.{EitherT,OptionT}
import cats.syntax.applicative._
import cats.instances.future._ // for monad
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

/*
It becomes confusing when there are more than one stack elemats
 */
object MonadStackUsingFuture extends App{

  // future either

  type FutureEither[A] = EitherT[Future, String, A]
  type FutureEitherOption[A] = OptionT[FutureEither,A]

  val futureEitherOr: FutureEitherOption[Int] =
    for {
      a <- 10.pure[FutureEitherOption]
      b <- 32.pure[FutureEitherOption]
    } yield a + b
println(futureEitherOr)
}
