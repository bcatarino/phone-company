package phone.com.model

import java.time.LocalTime

import org.scalatest.{Matchers, WordSpec}

class CustomerCallSpec extends WordSpec with Matchers {

  "CustomerCall#price" should {
    "be 0 if call has no duration" in {
      CustomerCall("A", "555-433-242", LocalTime.of(0, 0, 0)).price shouldBe BigDecimal(0)
    }

    "50p for 10 seconds" in {
      CustomerCall("A", "555-433-242", LocalTime.of(0, 0, 10)).price shouldBe BigDecimal(0.5)
    }

    "£3 for 60 seconds" in {
      CustomerCall("A", "555-433-242", LocalTime.of(0, 1, 0)).price shouldBe BigDecimal(3.0)
    }

    "£3.05 for 61 seconds" in {
      CustomerCall("A", "555-433-242", LocalTime.of(0, 1, 1)).price shouldBe BigDecimal(3.05)
    }

    "£8.95 for 179 seconds" in {
      CustomerCall("A", "555-433-242", LocalTime.of(0, 2, 59)).price shouldBe BigDecimal(8.95)
    }

    "£5.40 for 180 seconds, using cheaper price" in {
      CustomerCall("A", "555-433-242", LocalTime.of(0, 3, 0)).price shouldBe BigDecimal(5.40)
    }

    "£5.43 for 181 seconds, using cheaper price" in {
      CustomerCall("A", "555-433-242", LocalTime.of(0, 3, 1)).price shouldBe BigDecimal(5.43)
    }
  }
}
