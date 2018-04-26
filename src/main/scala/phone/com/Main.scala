package phone.com

import phone.com.Promotions.removeMostPopularNumber
import phone.com.io.LogReader
import phone.com.model.CustomerStatement

object Main extends App {

  val allCalls = new LogReader().readCallLogs("calls.log")

  val customerStatement = allCalls.groupBy(_.customerId)
                               .map(calls => CustomerStatement(calls._1, removeMostPopularNumber(allCalls)(calls._2)))

  customerStatement.map(cs => List(cs.id, cs.totalCost).mkString(" - ")).foreach(println)
}
