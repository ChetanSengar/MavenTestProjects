package org.tms.service.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tms.model.Notification;
import org.tms.model.User;
import org.tms.repo.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void sendBatchNotifications(List<User> users, String message) {
        List<Notification> notifications = users.stream()
                .map(user -> new Notification(null, user, message, LocalDateTime.now()))
                .collect(Collectors.toList());
        notificationRepository.saveAll(notifications);
    }

    @Override
    public void sendNotification(User recipient, String message) {
        Notification notification = new Notification(null, recipient, message, LocalDateTime.now());
        notificationRepository.save(notification);
    }

    @Override
    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

}
