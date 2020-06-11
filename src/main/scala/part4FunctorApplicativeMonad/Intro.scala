package part4FunctorApplicativeMonad

object Intro {
  /*
  Functor --- method of abstraction that allows us to operate sequence of
  operation on the list, option , either

  We are interested in pure functional programming
  f:A->B and a:A there exists a b:B such that f(a)=b
  for all expression f(x) can be safely placed
  No null or exception throwing
  no mutation print statements or side effects in general
  the concept of null is useful
  Instead of having an universal sentinel value that
  inhabits every type, make it data just like everything else
  Some functions we want to write will be partial
  a Either [Error,A]
  sealed trail Either[E,A]
   Mutation
   many computations need state that we can read and write to
   View the component as function start staate to the computed value and the new state
   f:A-->B that "do something" besides returning a B, augment the return type

    foo(a:Foo):Option[Bar]
    bar(a:Foo):Either[Error,Bar]
 ---> Often referred to as effectful functions
 ---> Option, Either, state etc are effecrs
 ----> Values without these behaviour are poor

   */


  /*
  Option -- Value may or may not be present
  Either -- There may be a value or an Error
  List  -- 0 or more elements
   */

}
