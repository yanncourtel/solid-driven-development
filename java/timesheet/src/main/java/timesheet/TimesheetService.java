package timesheet;

public class TimesheetService {
    public boolean hasTimesheets(Worker worker) {
        Timesheet ts = worker.getTimesheet(); // This directly uses Employee, violating DIP

        return ts != null;
    }
}
