package org.tms.service.NotificationService;

import org.tms.model.Notification;
import org.tms.model.User;

import java.util.List;

public interface NotificationService {
    void sendBatchNotifications(List<User> users, String message);
    void sendNotification(User recipient, String message);
    Notification getNotificationById(Long id);
}
