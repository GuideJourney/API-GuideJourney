package com.guidejourney.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.guidejourney.services.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send")
    public String sendNotification(@RequestParam String to, @RequestParam String subject, @RequestParam String body) {
        notificationService.sendSimpleMessage(to, subject, body);
        return "Notificación enviada";
    }
}
