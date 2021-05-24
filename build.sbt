val scala3Version = "3.0.0"
val catsVersion = "2.6.1"
val catsEffectVersion = "3.1.1"
val catsMtlVersion = "1.2.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "cats-playground",
    version := "0.1.0",

    scalaVersion := scala3Version,
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

      /*
       * test libs
       */
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.scalacheck" %% "scalacheck" % "1.15.4" % Test,
      "com.novocode" % "junit-interface" % "0.11" % Test,
    )
  )
