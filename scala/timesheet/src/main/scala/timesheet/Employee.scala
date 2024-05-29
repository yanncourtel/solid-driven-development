package timesheet

import java.time.LocalDate

class Employee(val firstName: String, val lastName: String, val dateOfBirth: LocalDate, val email: String, var timesheet: Option[Timesheet] = None) extends Worker {

  def this(firstName: String, lastName: String, dateOfBirth: LocalDate, email: String) = {
    this(firstName, lastName, dateOfBirth, email, None)
  }

  override def getFirstName: String = firstName

  def getLastName: String = lastName

  def getDateOfBirth: LocalDate = dateOfBirth

  override def getEmail: String = email

  override def work(): Unit = {
    // working...
  }

  override def getTimesheet: Timesheet = timesheet.getOrElse(null)
}