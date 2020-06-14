package part5MonadTransformation


/*

It was noticed that there was no cats.syntax.applicative
cats.syntax.flatMap because  OptionT has its own flatMap and Map
Monad transform  is used to transform stack of monad
It is present in cats.data

• cats.data.OptionT for Option;
• cats.data.EitherT for Either;
• cats.data.ReaderT for Reader;
• cats.data.WriterT for Writer;
• cats.data.StateT for State;
• cats.data.IdT for the Id monad;

 */

import cats.data.OptionT
import cats.syntax.ListOps
import cats.Monad
import cats.instances.list._     // for Monad
import cats.syntax.applicative._ // for pure

object IntroToMonadTransformation extends App{
  type ListOption[A] = OptionT[List, A]


  val result1 = OptionT(List(Option(10)))
  println(result1)

//
  val result2: ListOption[Int] = 32.pure[ListOption] // result2: ListOption[Int] = OptionT(List(Some(32)))
  println(result2)

}
