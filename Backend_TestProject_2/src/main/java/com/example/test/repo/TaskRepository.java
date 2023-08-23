package com.example.test.repo;

import com.example.test.model.Task;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task>{
    List<Task> findTasksCompletedBetweenDates(Date startDate, Date endDate);
}
