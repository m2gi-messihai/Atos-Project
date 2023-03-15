package com.example.notificationmanagementmicroservice.dto;

import com.example.notificationmanagementmicroservice.model.NotificationTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    String userId;
    String timestamp;
    String examName;
    String url;
    NotificationTypeEnum eventType;

}
