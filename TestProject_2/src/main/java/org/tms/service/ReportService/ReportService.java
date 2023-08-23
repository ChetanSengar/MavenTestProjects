package org.tms.service.ReportService;

import org.tms.model.Task;

import java.util.Date;
import java.util.List;

public interface ReportService {
    List<Task> getTasksCompletedBetweenDates(Date startDate, Date endDate);

    int getActiveUsersCount();

    // Other methods as per requirements...
}
