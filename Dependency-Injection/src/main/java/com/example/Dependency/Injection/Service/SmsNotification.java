package com.example.Dependency.Injection.Service;

import com.example.Dependency.Injection.Modellor.NotificationService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service

public class SmsNotification implements NotificationService {

    public SmsNotification() {
        System.out.println("SmsNotification"+" "+this.hashCode());
    }
    public void message(String message) {
        System.out.println(message+this.hashCode()+" "+this.getClass().getSimpleName());
    }
}
