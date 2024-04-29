package timesheet;

import java.util.List;

public interface EmployeeRepository {
    List<Worker> findActiveWorkers();
}
