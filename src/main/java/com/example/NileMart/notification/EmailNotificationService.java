package com.example.NileMart.notification;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
public class EmailNotificationService implements NotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println(" Email : " + message);
    }
}
