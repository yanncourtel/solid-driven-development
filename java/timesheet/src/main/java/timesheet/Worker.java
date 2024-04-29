package timesheet;

public interface Worker {
    String getFirstName();

    String getEmail();

    void work();
    Timesheet getTimesheet();  // Not all Worker types can support this, which will violate LSP
}
