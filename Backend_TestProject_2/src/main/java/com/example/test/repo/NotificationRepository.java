package com.example.test.repo;

import com.example.test.model.Notification;
import com.example.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Example: Find all notifications for a specific user
    List<Notification> findByRecipient(User recipient);
}
