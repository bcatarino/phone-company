package phone.com.io

import phone.com.CallParser
import phone.com.model.CustomerCall

import scala.io.Source

class LogReader {

  val parser = new CallParser

  def readCallLogs(filename: String): List[CustomerCall] = {
    Source.fromResource(filename).getLines
      .map(parser.parseRow)
      .filter(_.isDefined)
      .map(_.get).toList
  }
}
