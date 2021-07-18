val scala3Version = "3.1.0-RC1"

val catsVersion = "2.6.1"
val catsEffectVersion = "3.1.1"
val catsMtlVersion = "1.2.0"
val shapeless3Version = "3.0.1"
val zioVersion = "1.0.9"
val fs2Version = "3.0.6"
val http4sVersion = "1.0.0-M23"

lazy val root = project
  .in(file("."))
  .settings(
    name := "cats-playground",
    version := "0.1.0",

    scalaVersion := scala3Version,

    scalacOptions ++= Seq(
      "-feature",
      "-unchecked",
      "-deprecation",
      // http://dotty.epfl.ch/docs/reference/other-new-features/explicit-nulls.html
      //"-Yexplicit-nulls",
    ),

    libraryDependencies ++= Seq(
      /*
       * Cats Libs
       * https://github.com/typelevel/cats
       */
      "org.typelevel" %% "cats-kernel" % catsVersion,
      "org.typelevel" %% "cats-core" % catsVersion,
      "org.typelevel" %% "cats-laws" % catsVersion % Test,
      "org.typelevel" %% "cats-free" % catsVersion,
      "org.typelevel" %% "cats-testkit" % catsVersion % Test,
      "org.typelevel" %% "alleycats-core" % catsVersion,

      /*
       * other cats modules
       */
      // cats-effect
      // https://github.com/typelevel/cats-effect
      "org.typelevel" %% "cats-effect-kernel" % catsEffectVersion,
      "org.typelevel" %% "cats-effect-laws" % catsEffectVersion % Test,
      "org.typelevel" %% "cats-effect-std" % catsEffectVersion,
      "org.typelevel" %% "cats-effect" % catsEffectVersion % Test,
      "org.typelevel" %% "cats-effect-testkit" % catsEffectVersion % Test,
      // cats-mtl
      // https://github.com/typelevel/cats-mtl
      // "org.typelevel" %% "cats-mtl" % catsMtlVersion,
      // "org.typelevel" %% "cats-mtl-laws" % catsMtlVersion % Test,
      // mouse
      // https://github.com/typelevel/mouse
      // "org.typelevel" %% "mouse" % "1.0.2",
      // cats-testkit-scalatest
      // https://github.com/typelevel/cats-testkit-scalatest
      "org.typelevel" %% "cats-testkit-scalatest" % "2.1.5" % Test,

      // shapeless
      // https://github.com/typelevel/shapeless-3
      "org.typelevel" %% "shapeless3-deriving" % shapeless3Version,
      "org.typelevel" %% "shapeless3-typeable" % shapeless3Version,
      // Spire: Numerics library
      // https://github.com/typelevel/spire
      // "org.typelevel" %% "spire" % "0.17.0",
      // squants: The Scala API for Quantities, Units of Measure and Dimensional Analysis
      // https://github.com/typelevel/squants
      // "org.typelevel" %% "squants" % "1.8.0",

      /*
       * other cat related cool libs
       */
      // monocle
      // https://www.optics.dev/Monocle/
      "dev.optics" %% "monocle-core" % "3.0.0",

      // Monix: Asynchronous Programming for Scala and Scala.js.
      // https://monix.io/
      // "io.monix" %% "monix" % "3.4.0",

      // FS2: Functional streams for Scala
      // https://fs2.io/
      // available for 2.12, 2.13, 3.0
      "co.fs2" %% "fs2-core" % fs2Version,
      // optional I/O library
      "co.fs2" %% "fs2-io" % fs2Version,
      // optional reactive streams interop
      "co.fs2" %% "fs2-reactive-streams" % fs2Version,

      // ToFu
      // https://github.com/tofu-tf/tofu
      // "tf.tofu" %% "tofu" % "0.10.2",

      // zio: Type-safe, composable asynchronous and concurrent programming for Scala
      // https://zio.dev/
      "dev.zio" %% "zio" % zioVersion,
      "dev.zio" %% "zio-streams" % zioVersion,
      // https://github.com/zio/interop-cats
      "dev.zio" %% "zio-interop-cats" % "3.1.1.0",

      // http4s: Functional, streaming HTTP.
      // https://http4s.org
      "org.http4s" %% "http4s-core" % http4sVersion,
      "org.http4s" %% "http4s-dsl" % http4sVersion,

      // Cats STM: Software transactional memory for Cats Effect
      // https://timwspence.github.io/cats-stm/
      "io.github.timwspence" %% "cats-stm" % "0.10.3",

      /*
       * test libs
       */
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.scalacheck" %% "scalacheck" % "1.15.4" % Test,
      "com.novocode" % "junit-interface" % "0.11" % Test,
    )
  )
