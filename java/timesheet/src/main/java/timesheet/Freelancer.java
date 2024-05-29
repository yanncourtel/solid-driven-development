package timesheet;

public class Freelancer implements Worker {
    private String firstName;
    private String email;

    public Freelancer(String firstName, String email) {
        this.firstName = firstName;
        this.email = email;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void work() { /* Some freelance work */ }
    
    public Timesheet getTimesheet() {
        throw new UnsupportedOperationException("Freelancer doesn't support timesheets.");
    }
}
