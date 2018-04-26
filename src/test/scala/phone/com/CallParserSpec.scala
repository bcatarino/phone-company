package phone.com

import java.time.LocalTime

import org.scalatest.{Matchers, WordSpec}
import phone.com.model.CustomerCall

class CallParserSpec extends WordSpec with Matchers {

  val callParser = new CallParser

  "LoggedCallParser#parseRow" should {

    "return None for empty input" in {
      callParser.parseRow("") shouldBe None
    }

    "return Customer Call" in {
      val result = callParser.parseRow("A 555-333-212 00:02:03")
      result.get shouldBe CustomerCall("A", "555-333-212", LocalTime.of(0, 2, 3))
    }

    "return Customer Call for longer names" in {
      val result = callParser.parseRow("ABVDIOHDBSA 555-333-212 00:02:03")
      result.get shouldBe CustomerCall("ABVDIOHDBSA", "555-333-212", LocalTime.of(0, 2, 3))
    }

    "return None if string does not match pattern" in {
      callParser.parseRow("A 555-333-212 00:02-03") shouldBe None
    }

    "return None if not all fields are available" in {
      callParser.parseRow("555-333-212 00:02:03") shouldBe None
    }
  }
}
