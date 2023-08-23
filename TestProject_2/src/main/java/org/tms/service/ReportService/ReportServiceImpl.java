package org.tms.service.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tms.model.Task;
import org.tms.repo.TaskRepository;

import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getTasksCompletedBetweenDates(Date startDate, Date endDate) {
        // Assuming we'll have a custom method in your TaskRepository
        return taskRepository.findTasksCompletedBetweenDates(startDate, endDate);
    }

    @Override
    public int getActiveUsersCount() {
        // Example method, would need a UserRepository to fetch actual data
        return 0;
    }
}
