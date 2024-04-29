package timesheet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.MonthDay;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TimesheetReminderServiceShould {
    private static final int CURRENT_MONTH = 7;
    private static final int CURRENT_DAY_OF_MONTH = 9;
    private static final MonthDay TODAY = MonthDay.of(CURRENT_MONTH, CURRENT_DAY_OF_MONTH);
    private final ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private TimesheetReminderService timesheetReminderService;

    @Test
    void should_send_greeting_email_to_employee() {
        System.setOut(new PrintStream(consoleContent));
        Employee employee = EmployeeBuilder.anEmployee().build();
        given(employeeRepository.findActiveWorkers()).willReturn(Collections.singletonList(employee));

        timesheetReminderService.sendTimesheetReminder();

        String actual = consoleContent.toString();
        assertThat(actual)
                .isEqualTo("To:" + employee.getEmail() + ", Subject: Your timesheet is missing!!, Message: You have some timesheet missing. Please hurry to send them. " + employee.getFirstName() + "!");
    }
}