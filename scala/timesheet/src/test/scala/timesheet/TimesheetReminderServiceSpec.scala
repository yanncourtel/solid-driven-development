package timesheet

import org.mockito.BDDMockito.`given`
import org.mockito.MockitoSugar
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import java.io.{ByteArrayOutputStream, PrintStream}
import java.time.{LocalDateTime, MonthDay}

class TimesheetReminderServiceSpec extends AnyFlatSpec with Matchers with MockitoSugar {
  private val CURRENT_MONTH = 7
  private val CURRENT_DAY_OF_MONTH = 9
  private val TODAY: MonthDay = MonthDay.of(CURRENT_MONTH, CURRENT_DAY_OF_MONTH)
  private val consoleContent = new ByteArrayOutputStream()
  private val employeeRepository: EmployeeRepository = mock[EmployeeRepository]
  private val timesheetReminderService = new TimesheetReminderService(employeeRepository)

  "TimesheetReminderService" should "send timesheet notification by email to employee" in {
    System.setOut(new PrintStream(consoleContent))
    val employee = EmployeeBuilder.anEmployee().lastTimesheetAsOf(0).build()
    given(employeeRepository.findActiveWorkers()).willReturn(List(employee))

    timesheetReminderService.sendTimesheetReminder()

    val actual = consoleContent.toString
    actual shouldEqual s"To:${employee.getEmail}, Subject: Your timesheet is missing!!, Message: You have some timesheet missing. Please hurry to send them. ${employee.getFirstName}!"
  }

  it should "not send timesheet notification by email to employee if submitted" in {
    val thisMonth = LocalDateTime.now().getMonthValue
    System.setOut(new PrintStream(consoleContent))
    val employee = EmployeeBuilder.anEmployee().lastTimesheetAsOf(thisMonth).build()
    given(employeeRepository.findActiveWorkers()).willReturn(List(employee))

    timesheetReminderService.sendTimesheetReminder()

    val actual = consoleContent.toString
    actual shouldEqual ""
  }

  it should "send timesheet notification by email to freelancer" in {
    System.setOut(new PrintStream(consoleContent))
    val freelancer = FreelancerBuilder.aFreelancer().build()
    given(employeeRepository.findActiveWorkers()).willReturn(List(freelancer))

    timesheetReminderService.sendTimesheetReminder()

    val actual = consoleContent.toString
    actual shouldEqual s"To:${freelancer.getEmail}, Subject: Your timesheet is missing!!, Message: You have some timesheet missing. Please hurry to send them. ${freelancer.getFirstName}!"
  }
}
