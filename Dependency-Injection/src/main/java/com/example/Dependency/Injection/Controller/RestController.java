package com.example.Dependency.Injection.Controller;

import com.example.Dependency.Injection.Modellor.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component

public class RestController {
    @Autowired
    @Qualifier("smsNotification")
    private NotificationService notificationService;

    public void sendMessage(String message) {
        notificationService.message(message);
    }

}
