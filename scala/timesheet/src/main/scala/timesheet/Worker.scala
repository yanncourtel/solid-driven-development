package timesheet

trait Worker {
  def getFirstName: String
  def getEmail: String
  def work(): Unit
  def getTimesheet: Timesheet
}
