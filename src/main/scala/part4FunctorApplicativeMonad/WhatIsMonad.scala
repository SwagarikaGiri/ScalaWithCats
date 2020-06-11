package part4FunctorApplicativeMonad
import scala.language.higherKinds

object WhatIsMonad extends App{


  trait Monad[F[_]]{
    def pure[A](value:A):F[A]
    def flatMap[A,B](value: F[A])(func: A =>F[B]) : F[B]
  }
  /*

  Monad laws

  Left Identity   pure(a).flatMap(func)==func(a)
  Right Identity  m.flatMap(pure) == m
  Associativity   m.flatMap(A).flatMap(G) == m.flatMap(x => f(x).flatMap(g))

   */


}
