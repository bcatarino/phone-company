package phone.com.model

import java.time.LocalTime
import CustomerCall._

case class CustomerCall(customerId: String, phoneNumber: String, duration: LocalTime) {
  /*
   * Based on the problem description, my understanding is that if a call is over 3 minutes, all the duration is charged
   * at the same price, and not the first 3 minutes more expensive and the remaining cheaper, so the implementation
   * reflects what I believe was being asked. In a real scenario, I'd clear up the requirements with someone.
   */
  lazy val price: BigDecimal = {
    val totalSeconds = duration.getHour * 3600 + duration.getMinute * 60 + duration.getSecond
    if (totalSeconds >= priceThreshold) cheaperPrice.*(totalSeconds)
    else higherPrice.*(totalSeconds)
  }

  override def toString: String = "(" + List(phoneNumber, duration, price).mkString(", ") + ")"
}

object CustomerCall {
  val priceThreshold = 180
  val cheaperPrice = BigDecimal(0.03)
  val higherPrice = BigDecimal(0.05)
}