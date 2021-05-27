package demo

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
 * https://www.scalatest.org/quick_start
 */
class FooSpec extends AnyFlatSpec with Matchers {
  "String in Main" should "equal expected" in {
    msg shouldEqual "I was compiled by Scala 3. :)"
  }
}
