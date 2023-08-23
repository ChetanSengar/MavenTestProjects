package com.example.test.service.ReportService;

import com.example.test.model.Task;
import com.example.test.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
