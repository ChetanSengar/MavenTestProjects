package com.example.test.service.NotificationService;

import com.example.test.model.Notification;
import com.example.test.model.User;
import com.example.test.repo.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void sendBatchNotifications(List<User> users, String message) {
        List<Notification> notifications = users.stream()
                .map(user -> new Notification(null, message, LocalDateTime.now()))
                .collect(Collectors.toList());
        notificationRepository.saveAll(notifications);
    }

    @Override
    public void sendNotification(String recipient, String message) {
        Notification notification = new Notification(null, message, LocalDateTime.now());
        notificationRepository.save(notification);
    }

    @Override
    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }
}
