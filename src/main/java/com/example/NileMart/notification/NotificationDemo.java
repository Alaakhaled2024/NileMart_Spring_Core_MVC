package com.example.NileMart.notification;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class NotificationDemo {
    List <NotificationService>notificationServices;
    NotificationDemo( List <NotificationService>notificationServices){
        this.notificationServices=notificationServices;
    }
    public void printNotificationServices(){
        for(NotificationService notificationService:notificationServices){
           notificationService.sendNotification("welcome");
        }

    }
}
