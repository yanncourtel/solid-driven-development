package timesheet;

import java.time.LocalDateTime;
import java.util.List;

public class TimesheetReminderService {
    private final EmployeeRepository employeeRepository;

    public TimesheetReminderService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void sendTimesheetReminder() {
        List<Worker> activeWorkers = employeeRepository.findActiveWorkers();
        activeWorkers
                .stream()
                .filter(emp -> !new TimesheetService().hasTimesheets(emp, LocalDateTime.now()))
                .map(employee -> emailFor(employee))
                .forEach(email -> new EmailSender().send(email));
    }

    private Email emailFor(Worker worker) {
        String message = String.format("You have some timesheet missing. Please hurry to send them. %s!", worker.getFirstName());
        return new Email(worker.getEmail(), "Your timesheet is missing!!", message);
    }

}


