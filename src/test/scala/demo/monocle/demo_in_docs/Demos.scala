package demo.monocle.demo_in_docs

import monocle.syntax.all._

import scala.util.chaining._


// demo code of optics official site
// - home page https://www.optics.dev/Monocle/
// - GET STARTED https://www.optics.dev/Monocle/docs/focus
//
// more example see
// https://github.com/optics-dev/Monocle/tree/master/example/src/test/scala


package homepage:

  case class User(name: String, address: Address)

  case class Address(streetNumber: Int, streetName: String)

  /**
   * Demo code of optics
   *
   * - home page https://www.optics.dev/Monocle/
   */
  @main
  def HelloWorld: Unit =
    val user = User("Anna", Address(12, "high street"))

    user.focus(_.name).replace("Bob")
      .tap(println) // res: User = User("Bob", Address(12, "high street"))

    user.focus(_.address.streetName).modify(_.toUpperCase)
      .tap(println) // res: User = User("Anna", Address(12, "HIGH STREET"))

    user.focus(_.address.streetNumber).get
      .tap(println) // res: Int = 12

end homepage


package update_optional_field:

  case class User(name: String, address: Option[Address])

  case class Address(streetNumber: Int, streetName: String)

  /**
   * Update an optional field of a case class (Scala 3 only)
   *
   * GET STARTED https://www.optics.dev/Monocle/docs/focus
   */
  @main
  def UpdateOptionalField: Unit =
    val anna = User("Anna", Some(Address(12, "high street")))
    val bob = User("bob", None)

    anna
      .focus(_.address.some.streetNumber)
      .modify(_ + 1)
      .tap(println)
    // res: User = User(
    //   name = "Anna",
    //   address = Some(value = Address(streetNumber = 13, streetName = "high street"))
    // )

    bob
      .focus(_.address.some.streetNumber)
      .modify(_ + 1)
      .tap(println) // res: User = User(name = "bob", address = None)

end update_optional_field


package update_single_element_inside_a_list:

  import java.time.YearMonth

  case class User(name: String, debitCards: List[DebitCard])

  case class DebitCard(cardNumber: String, expirationDate: YearMonth, securityCode: Int)

  /**
   * Update a single element inside a List (Scala 3 only)
   *
   * GET STARTED https://www.optics.dev/Monocle/docs/focus
   */
  @main
  def UpdateSingleElementInsideAList: Unit =
    val anna = User(
      "Anna",
      List(
        DebitCard("4568 5794 3109 3087", YearMonth.of(2022, 4), 361),
        DebitCard("5566 2337 3022 2470", YearMonth.of(2024, 8), 990)
      )
    )

    val bob = User("Bob", List())

    anna
      .focus(_.debitCards.index(0).expirationDate)
      .replace(YearMonth.of(2026, 2))
      .tap(println)
    // res: User = User(
    //   name = "Anna",
    //   debitCards = List(
    //     DebitCard(
    //       cardNumber = "4568 5794 3109 3087",
    //       expirationDate = 2022-04,
    //       securityCode = 361
    //     ),
    //     DebitCard(
    //       cardNumber = "5566 2337 3022 2470",
    //       expirationDate = 2026-02,
    //       securityCode = 990
    //     )
    //   )
    // )

    bob
      .focus(_.debitCards.index(1).as[DebitCard].expirationDate)
      .replace(YearMonth.of(2026, 2))
      .tap(println) // res: User = User("Bob", List())

end update_single_element_inside_a_list

