package demo.reference

/**
 * https://dotty.epfl.ch/docs/reference/new-types/dependent-function-types.html
 */
package dependentfunctiontypes


import scala.util.chaining.*


trait Entry {
  type Key;
  val key: Key
}

def extractKey(e: Entry): e.Key = e.key

val extractor: (e: Entry) => e.Key = extractKey


class Entry1 extends Entry {
  override type Key = String
  override val key = "hello"
}


class Entry2 extends Entry {
  override type Key = String
  override val key = "world"
}


@main def DependentFunctionTypes: Unit =
  val entry1 = new Entry {
    override type Key = String
    override val key = "hello"
  }
  val k1: entry1.Key = extractor(entry1)
  k1.tap(println)

  val entry2 = new Entry2
  var k2: entry2.Key = extractor(entry2)
  k2.tap(println)

  k2 = k1
  k2.tap(println)


