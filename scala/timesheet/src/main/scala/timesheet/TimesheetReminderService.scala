package timesheet

import java.time.LocalDateTime

class TimesheetReminderService(employeeRepository: EmployeeRepository) {

  def sendTimesheetReminder(): Unit = {
    val activeWorkers = employeeRepository.findActiveWorkers()
    activeWorkers
      .filter(emp => !new TimesheetService().hasTimesheets(emp, LocalDateTime.now()))
      .map(employee => emailFor(employee))
      .foreach(email => new EmailSender().send(email))
  }

  private def emailFor(worker: Worker): Email = {
    val message = s"You have some timesheet missing. Please hurry to send them. ${worker.getFirstName}!"
    new Email(worker.getEmail, "Your timesheet is missing!!", message)
  }
}
