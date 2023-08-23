package org.tms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tms.model.Notification;
import org.tms.model.User;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Example: Find all notifications for a specific user
    List<Notification> findByRecipient(User recipient);
}
