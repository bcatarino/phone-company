package phone.com

import phone.com.model.CustomerCall

object Promotions {

  def removeMostPopularNumber(calls: List[CustomerCall]): List[CustomerCall] => List[CustomerCall] = {
    val promotionNumber = calls.groupBy(_.phoneNumber).maxBy(_._2.length)._1
    c => c.filterNot(_.phoneNumber.contentEquals(promotionNumber))
  }
}
