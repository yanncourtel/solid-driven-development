package timesheet

import java.time.LocalDateTime

class TimesheetService {
  def hasTimesheets(worker: Worker, date: LocalDateTime): Boolean = {
    val ts = worker.getTimesheet
    ts.getMonthNumber == date.getMonthValue
  }
}
