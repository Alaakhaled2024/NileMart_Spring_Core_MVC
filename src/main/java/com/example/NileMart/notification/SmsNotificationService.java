package com.example.NileMart.notification;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class SmsNotificationService implements NotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println(" SMS : " + message);
    }
}
