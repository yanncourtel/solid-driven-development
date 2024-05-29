package timesheet

trait EmployeeRepository {
  def findActiveWorkers(): List[Worker]
}