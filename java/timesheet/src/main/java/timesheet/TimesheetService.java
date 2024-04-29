package timesheet;

import java.time.LocalDateTime;

public class TimesheetService {
    public boolean hasTimesheets(Worker worker, LocalDateTime date) {
        Timesheet ts = worker.getTimesheet();

        return ts.getMonthNumber() == date.getMonthValue();
    }
}
