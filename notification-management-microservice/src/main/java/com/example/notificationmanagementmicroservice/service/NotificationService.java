package com.example.notificationmanagementmicroservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notificationmanagementmicroservice.dto.EventDto;
import com.example.notificationmanagementmicroservice.dto.NotificationDto;
import com.example.notificationmanagementmicroservice.model.Notification;
import com.example.notificationmanagementmicroservice.model.NotificationTypeEnum;
import com.example.notificationmanagementmicroservice.repository.NotificationRepository;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private ModelMapper modelMapper;

    public NotificationDto saveNotification(EventDto eventDto) {
        NotificationDto notificationDto = new NotificationDto(eventDto.getUserId(), eventDto.getTimestamp(),
                eventDto.getUrl(), null);
        if (eventDto.getEventType() == NotificationTypeEnum.EXAM_ASSIGNMENT) {
            notificationDto.setMessage("you have been assigned " + eventDto.getExamName());
        } else if (eventDto.getEventType() == NotificationTypeEnum.EXAM_SUBMISSION) {
            notificationDto.setMessage("Exam " + eventDto.getExamName() + " has been submitted ");
        }
        Notification notification = modelMapper.map(notificationDto,
                Notification.class);
        notificationRepository.save(notification);
        return modelMapper.map(notification, NotificationDto.class);
    }

}
