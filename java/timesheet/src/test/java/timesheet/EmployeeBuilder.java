package timesheet;

import java.time.LocalDate;

public class EmployeeBuilder {

    private String firstName = "John";
    private String lastName = "Doe";
    private LocalDate dateOfBirth = LocalDate.of(1980, 9, 10);
    private String email = "john.doe@foobar.com";
    private Timesheet timesheet = new Timesheet(0);

    public static EmployeeBuilder anEmployee(){
        return new EmployeeBuilder();
    }

    public EmployeeBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public EmployeeBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }


    public EmployeeBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeBuilder withDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }
    public EmployeeBuilder lastTimesheetAsOf(int monthNumber) {
        this.timesheet = new Timesheet(monthNumber);
        return this;
    }

    public Employee build(){
        return new Employee(firstName, lastName, dateOfBirth, email, timesheet);
    }

}
