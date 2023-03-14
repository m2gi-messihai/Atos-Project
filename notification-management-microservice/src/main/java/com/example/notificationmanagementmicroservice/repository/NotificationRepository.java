package com.example.notificationmanagementmicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.notificationmanagementmicroservice.model.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {

}
