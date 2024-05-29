package timesheet

class Freelancer(val firstName: String, val email: String) extends Worker {

  override def getFirstName: String = firstName

  override def getEmail: String = email

  override def work(): Unit = {
    // Some freelance work
  }

  override def getTimesheet: Timesheet = {
    throw new UnsupportedOperationException("Freelancer doesn't support timesheets.")
  }
}