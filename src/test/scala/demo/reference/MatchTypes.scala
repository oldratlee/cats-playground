package demo.reference

/**
 * https://dotty.epfl.ch/docs/reference/new-types/match-types.html
 */
package matchtypes


import scala.util.chaining.*


type Elem[X] = X match
  case String => Char
  case Array[t] => t
  case Iterable[t] => t

type LeafElem[X] = X match
  case String => Char
  case Array[t] => LeafElem[t]
  case Iterable[t] => LeafElem[t]
  case AnyVal => X


type Concat[Xs <: Tuple, +Ys <: Tuple] <: Tuple = Xs match
  case EmptyTuple => Ys
  case x *: xs => x *: Concat[xs, Ys]


@main def MatchTypes: Unit =
  val s: Elem[String] = "abc".head
  s.tap(println)


def leafElem[X](x: X): LeafElem[X] = x match
  case x: String => x.charAt(0)
  case x: Array[t] => leafElem(x(0))
  case x: Iterable[t] => leafElem(x.head)
  case x: AnyVal => x


@main def DependentTyping: Unit =
  leafElem("abc").tap(println)
  leafElem(Array(0, 1, 2, 3)).tap(println)
  leafElem(Vector(false, true, false)).tap(println)


type L[X] = X match
  case Int => L[X]

def g[X]: L[X] = ???


@main def Termination: Unit = {
  // val x: Int = g[Int]

  // Compile Error:
  //
  // |  val x: Int = g[Int]
  // |                ^
  // |Recursion limit exceeded.
  // |Maybe there is an illegal cyclic reference?
  // |If that's not the case, you could also try to
  // |increase the stacksize using the -Xss JVM option.
  // |A recurring operation is (inner to outer):
  // |
  // |  subtype LazyRef(Test.L[Int]) <:< Int
}
