package timesheet

case class Timesheet(private var monthNumber: Int) {
  def getMonthNumber: Int = monthNumber
  def setMonthNumber(monthNumber: Int): Unit = {
    this.monthNumber = monthNumber
  }
}
