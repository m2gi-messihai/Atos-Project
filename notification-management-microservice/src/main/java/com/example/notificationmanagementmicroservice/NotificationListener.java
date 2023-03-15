package com.example.notificationmanagementmicroservice;

import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import com.example.notificationmanagementmicroservice.dto.EventDto;
import com.example.notificationmanagementmicroservice.service.NotificationService;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class NotificationListener {
    @Autowired
    NotificationService notificationService;
    private Logger log = LoggerFactory.getLogger(NotificationListener.class);

    @KafkaListener(topics = "notification", groupId = "notification")
    @Payload
    void listener(String event) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        log.debug("hello" + event);
        EventDto eventDto = objectMapper.readValue(event, EventDto.class);
        notificationService.saveNotification(eventDto);
    }
}
