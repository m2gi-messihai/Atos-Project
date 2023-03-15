package com.example.exammicroservice.dto;

import com.example.exammicroservice.model.NotificationTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventDto {
    String userId;
    String timestamp;
    String examName;
    String url;
    NotificationTypeEnum eventType;

}
