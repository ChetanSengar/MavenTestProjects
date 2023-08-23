package com.example.test.service.NotificationService;


import com.example.test.model.Notification;
import com.example.test.model.User;

import java.util.List;

public interface NotificationService {
    void sendBatchNotifications(List<User> users, String message);
    void sendNotification(String recipient, String message);
    Notification getNotificationById(Long id);
}
