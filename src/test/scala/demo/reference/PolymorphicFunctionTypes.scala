package demo.reference


/**
 * https://dotty.epfl.ch/docs/reference/new-types/polymorphic-function-types.html
 */
package polymorphicfunctiontypes


def foo[A](xs: List[A]): List[A] =
  xs.reverse

val bar: [A] => List[A] => List[A] =
  [A] => (xs: List[A]) => foo[A](xs)


enum Expr[A]:
  case Var(name: String)
  case Apply[A, B](fun: Expr[B => A], arg: Expr[B]) extends Expr[A]


def mapSubExpressions[A](e: Expr[A])(f: [B] => Expr[B] => Expr[B]): Expr[A] =
  import Expr.{Apply, Var}

  e match
    case Apply(fun, arg) => Apply(f(fun), f(arg))
    case Var(n) => Var(n)


@main def PolymorphicFuncstionTypes: Unit =
  import Expr.{Apply, Var}

  val e0 = Apply(Var("f"), Var("a"))
  println(e0)

  val wrap = [B] => (se: Expr[B]) => Apply(Var[B => B]("wrap"), se)
  val e1 = mapSubExpressions(e0)(wrap)
  println(e1)
