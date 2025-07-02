package com.example.Dependency.Injection.Service;

import com.example.Dependency.Injection.Controller.RestController;
import com.example.Dependency.Injection.Modellor.NotificationService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PushNotification implements NotificationService {
    public PushNotification() {
        System.out.println("PushNotification"+" "+this.hashCode());
    }
    public void message(String message) {
        System.out.println(message+this.hashCode()+" "+this.getClass().getSimpleName());
    }
}
