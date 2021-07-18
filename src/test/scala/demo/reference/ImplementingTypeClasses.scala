package demo.reference

/**
 * Implementing Type classes - Scala Reference
 * https://dotty.epfl.ch/docs/reference/contextual/type-classes.html
 */
package typeclasses


import scala.util.chaining.*


trait SemiGroup[T]:
  extension (x: T) def combine(y: T): T


trait Monoid[T] extends SemiGroup[T] :
  def unit: T


given Monoid[String] with
  extension (x: String) def combine(y: String): String = x.concat(y)

  def unit: String = ""


given Monoid[Int] with
  extension (x: Int) def combine(y: Int): Int = x + y

  def unit: Int = 0


def combineAll[T: Monoid](xs: List[T]): T =
  xs.foldLeft(summon[Monoid[T]].unit)(_.combine(_))


object Monoid:
  def apply[T](using m: Monoid[T]) = m


def combineAll2[T: Monoid](xs: List[T]): T =
  xs.foldLeft(Monoid[T].unit)(_.combine(_))


@main def Typeclasses: Unit =
  combineAll(List(1, 2)).tap(println)
  combineAll2(List("a", "b")).tap(println)
