package phone.com.io

import java.time.LocalTime

import org.scalatest.{Matchers, WordSpec}
import phone.com.model.CustomerCall

class LogReaderSpec extends WordSpec with Matchers {

  val reader = new LogReader()

  "LogReader#readCallLogs" should {
    "return empty list for empty file" in {
      reader.readCallLogs("empty.log") shouldBe List.empty
    }

    "return list read from file" in {
      val expected = List(CustomerCall("A", "555-433-242", LocalTime.of(0, 6, 41)))
      reader.readCallLogs("simple.log") shouldBe expected
    }

    "skip invalid rows" in {
      val expected = List(CustomerCall("A", "555-433-242", LocalTime.of(0, 6, 41)),
                          CustomerCall("B", "555-334-789", LocalTime.of(0, 1, 59)))
      reader.readCallLogs("invalid.log") shouldBe expected
    }
  }
}