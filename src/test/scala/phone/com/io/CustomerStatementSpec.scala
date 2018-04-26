package phone.com.io

import java.time.LocalTime

import org.scalatest.{Matchers, WordSpec}
import phone.com.model.{CustomerCall, CustomerStatement}

class CustomerStatementSpec extends WordSpec with Matchers {

  "CustomerStatement#totalCost" should {
    "be 0 if no calls made" in {
      CustomerStatement("A", List()).totalCost shouldBe BigDecimal(0)
    }

    "be total of prices from calls made" in {
      CustomerStatement("A", List(CustomerCall("A", "555-433-242", LocalTime.of(0, 0, 4)),
                                  CustomerCall("A", "555-433-242", LocalTime.of(0, 3, 5)))).totalCost shouldBe BigDecimal(5.75)
    }
  }
}
