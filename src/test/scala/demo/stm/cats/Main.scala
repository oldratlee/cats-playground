package demo.stm.cats

import cats.effect.{IO, IOApp}
import io.github.timwspence.cats.stm.STM

import scala.concurrent.duration.DurationInt

/**
 * https://github.com/TimWSpence/cats-stm#example
 */
object Main extends IOApp.Simple {

  override def run: IO[Unit] = STM.runtime[IO].flatMap(run)

  def run(stm: STM[IO]): IO[Unit] = {
    import stm.*

    def transfer(accountForTim: TVar[Long], accountForSteve: TVar[Long]): IO[Unit] =
      stm.commit {
        for {
          balance <- accountForTim.get
          _ <- stm.check(balance > 100)
          _ <- accountForTim.modify(_ - 100)
          _ <- accountForSteve.modify(_ + 100)
        } yield ()
      }

    def giveTimMoreMoney(accountForTim: TVar[Long]): IO[Unit] =
      for {
        _ <- IO.sleep(5000.millis)
        _ <- stm.commit(accountForTim.modify(_ + 1))
      } yield ()

    def printBalances(accountForTim: TVar[Long], accountForSteve: TVar[Long]): IO[Unit] =
      for {
        t <- stm.commit(for {
          t <- accountForTim.get
          s <- accountForSteve.get
        } yield (t, s))
        (amountForTim, amountForSteve) = t
        _ <- IO(println(s"Tim: $amountForTim"))
        _ <- IO(println(s"Steve: $amountForSteve"))
      } yield ()

    for {
      accountForTim <- stm.commit(TVar.of[Long](100))
      accountForSteve <- stm.commit(TVar.of[Long](0))
      _ <- printBalances(accountForTim, accountForSteve)
      _ <- giveTimMoreMoney(accountForTim).start
      _ <- transfer(accountForTim, accountForSteve)
      _ <- printBalances(accountForTim, accountForSteve)
    } yield ()

  }

}
