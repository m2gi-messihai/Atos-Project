package com.example.notificationmanagementmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notificationmanagementmicroservice.dto.NotificationDto;
import com.example.notificationmanagementmicroservice.service.NotificationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public NotificationDto saveNotification(@RequestBody NotificationDto notificationDto) {
        return notificationService.saveNotification(notificationDto);
    }

}
