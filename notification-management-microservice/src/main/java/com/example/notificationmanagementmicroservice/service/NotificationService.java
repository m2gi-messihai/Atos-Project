package com.example.notificationmanagementmicroservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notificationmanagementmicroservice.dto.NotificationDto;
import com.example.notificationmanagementmicroservice.model.Notification;
import com.example.notificationmanagementmicroservice.repository.NotificationRepository;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private ModelMapper modelMapper;

    public NotificationDto saveNotification(NotificationDto notificationDto) {
        Notification notification = modelMapper.map(notificationDto, Notification.class);
        notificationRepository.save(notification);
        return modelMapper.map(notification, NotificationDto.class);
    }

}
