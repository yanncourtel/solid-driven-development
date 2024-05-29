package timesheet;

public interface Worker {
    String getFirstName();
    String getEmail();
    void work();
    Timesheet getTimesheet();
}
