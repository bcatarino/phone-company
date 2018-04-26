package phone.com

import java.time.LocalTime

import phone.com.model.CustomerCall

import scala.util.Try

class CallParser {

  def parseRow(row: String): Option[CustomerCall] = Try {
    val pattern = "([a-zA-Z ]+) ([0-9]{3}-[0-9]{3}-[0-9]{3}) (\\d\\d):(\\d\\d):(\\d\\d)".r
    val pattern(customerId, phoneNumber, hour, minute, second) = row
    CustomerCall(customerId, phoneNumber, LocalTime.of(hour.toInt, minute.toInt, second.toInt))
  }.toOption
}
