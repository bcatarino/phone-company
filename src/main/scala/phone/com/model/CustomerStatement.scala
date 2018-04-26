package phone.com.model

case class CustomerStatement(id: String, calls: List[CustomerCall]) {
  lazy val totalCost: BigDecimal = calls.map(_.price).sum

  override def toString: String = List("(", id, ", total cost: £", totalCost,
    ", calls: ", calls.mkString(","), ")").mkString
}