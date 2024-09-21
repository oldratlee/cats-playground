val scala3Version = "3.5.1"

val catsVersion = "2.12.0"
val catsEffectVersion = "3.5.4"
val catsMtlVersion = "1.5.0"

val shapeless3Version = "3.4.3"

val zioVersion = "2.1.9"
val fs2Version = "3.11.0"
val http4sVersion = "0.23.28"

lazy val root = project.in(file(".")).settings(
  name := "scala-playground",
  version := "0.1.0-SNAPSHOT",

  scalaVersion := scala3Version,

  scalacOptions ++= Seq(
    "-feature",
    "-unchecked",
    "-deprecation",
    // http://dotty.epfl.ch/docs/reference/other-new-features/explicit-nulls.html
    // "-Yexplicit-nulls",
  ),

  libraryDependencies ++= Seq(
    /*
     * Cats Libs
     * a library which provides abstractions for functional programming
     *   https://github.com/typelevel/cats
     */
    "org.typelevel" %% "cats-kernel" % catsVersion,
    "org.typelevel" %% "cats-core" % catsVersion,
    "org.typelevel" %% "cats-laws" % catsVersion % Test,
    "org.typelevel" %% "cats-free" % catsVersion,
    "org.typelevel" %% "cats-testkit" % catsVersion % Test,
    "org.typelevel" %% "alleycats-core" % catsVersion,
    // cats-testkit-scalatest
    //   https://github.com/typelevel/cats-testkit-scalatest
    "org.typelevel" %% "cats-testkit-scalatest" % "2.1.5" % Test,

    /*
     * other cats modules
     */
    // cats-effect
    // a high-performance, asynchronous, composable framework for building real-world applications
    // in a purely functional style within the Typelevel ecosystem.
    //   https://github.com/typelevel/cats-effect
    "org.typelevel" %% "cats-effect-kernel" % catsEffectVersion,
    "org.typelevel" %% "cats-effect-laws" % catsEffectVersion % Test,
    "org.typelevel" %% "cats-effect-std" % catsEffectVersion,
    "org.typelevel" %% "cats-effect" % catsEffectVersion,
    "org.typelevel" %% "cats-effect-testkit" % catsEffectVersion % Test,
    // cats-mtl
    // provides transformer typeclasses for cats' Monads, Applicatives and Functors
    //   https://github.com/typelevel/cats-mtl
    "org.typelevel" %% "cats-mtl" % catsMtlVersion,
    "org.typelevel" %% "cats-mtl-laws" % catsMtlVersion % Test,
    // mouse
    // a small companion to the Cats functional programming library for Scala,
    // includes convenience extension methods for Scala standard library classes
    //   https://github.com/typelevel/mouse
    "org.typelevel" %% "mouse" % "1.3.2",

    // shapeless
    // a type class and dependent type based generic programming library for Scala
    //   https://github.com/typelevel/shapeless-3
    "org.typelevel" %% "shapeless3-deriving" % shapeless3Version,
    "org.typelevel" %% "shapeless3-typeable" % shapeless3Version,
    // Spire: Numerics library
    // a numeric library for Scala which is intended to be generic, fast, and precise
    //   https://github.com/typelevel/spire
    "org.typelevel" %% "spire" % "0.18.0",
    // squants
    // The Scala API for Quantities, Units of Measure and Dimensional Analysis
    //   https://github.com/typelevel/squants
    "org.typelevel" %% "squants" % "1.8.3",

    /*
     * other cat related cool libs
     */
    // Monocle: access and transform immutable data
    // a Scala library which offers a simple yet powerful API to access and transform immutable data
    //   https://www.optics.dev/Monocle/
    "dev.optics" %% "monocle-core" % "3.3.0",

    // Monix: Asynchronous Programming for Scala and Scala.js.
    //   https://monix.io/
    // "io.monix" %% "monix" % "3.4.0",

    // FS2: Functional streams for Scala
    //   https://fs2.io/
    // available for 2.12, 2.13, 3.0
    "co.fs2" %% "fs2-core" % fs2Version,
    // optional I/O library
    "co.fs2" %% "fs2-io" % fs2Version,
    // optional reactive streams interop
    "co.fs2" %% "fs2-reactive-streams" % fs2Version,

    // ToFu
    //   https://github.com/tofu-tf/tofu
    // "tf.tofu" %% "tofu" % "0.10.2",

    // zio: Type-safe, composable asynchronous and concurrent programming for Scala
    //   https://zio.dev/
    "dev.zio" %% "zio" % zioVersion,
    "dev.zio" %% "zio-streams" % zioVersion,
    // https://github.com/zio/interop-cats
    "dev.zio" %% "zio-interop-cats" % "23.1.0.3",

    /*
     * STM
     */
    // Cats STM: Software transactional memory for Cats Effect
    //   https://timwspence.github.io/cats-stm/
    //   https://github.com/TimWSpence/cats-stm
    "io.github.timwspence" %% "cats-stm" % "0.13.5",
    // ZIO STM
    //   https://zio.dev/datatypes/stm/stm
    // Scala STM
    //   https://nbronson.github.io/scala-stm/
    //   https://github.com/nbronson/scala-stm
    "org.scala-stm" %% "scala-stm" % "0.11.1",

    // http4s: Functional, streaming HTTP.
    //   https://http4s.org
    "org.http4s" %% "http4s-core" % http4sVersion,
    "org.http4s" %% "http4s-dsl" % http4sVersion,

    /*
     * test libs
     */
    "org.scalatest" %% "scalatest" % "3.2.19" % Test,
    "org.scalacheck" %% "scalacheck" % "1.18.0" % Test,
    "junit" % "junit" % "4.13.2" % Test,
    "com.github.sbt" % "junit-interface" % "0.13.3" % Test,
  )
)
