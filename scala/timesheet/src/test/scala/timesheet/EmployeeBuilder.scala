package timesheet

import java.time.LocalDate

class EmployeeBuilder {
  private var firstName: String = "John"
  private var lastName: String = "Doe"
  private var dateOfBirth: LocalDate = LocalDate.of(1980, 9, 10)
  private var email: String = "john.doe@foobar.com"
  private var timesheet: Timesheet = Timesheet(0)

  def withEmail(email: String): EmployeeBuilder = {
    this.email = email
    this
  }

  def withFirstName(firstName: String): EmployeeBuilder = {
    this.firstName = firstName
    this
  }

  def withLastName(lastName: String): EmployeeBuilder = {
    this.lastName = lastName
    this
  }

  def withDateOfBirth(dateOfBirth: LocalDate): EmployeeBuilder = {
    this.dateOfBirth = dateOfBirth
    this
  }

  def lastTimesheetAsOf(monthNumber: Int): EmployeeBuilder = {
    this.timesheet = Timesheet(monthNumber)
    this
  }

  def build(): Worker = {
    new Employee(firstName, lastName, dateOfBirth, email, Some(timesheet))
  }
}

object EmployeeBuilder {
  def anEmployee(): EmployeeBuilder = new EmployeeBuilder()
}
