package com.example.notificationmanagementmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {
    String id;
    String userId;
    String timestanmp;
    String url;
    String message;

}
