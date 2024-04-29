package timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee implements Worker {
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final String email;

    private Timesheet timesheet;

    Employee(String firstName, String lastName, LocalDate dateOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    Employee(String firstName, String lastName, LocalDate dateOfBirth, String email, Timesheet timesheet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.timesheet = timesheet;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void work() {
        //working...
    }

    @Override
    public Timesheet getTimesheet() {
        return timesheet;
    }
}
