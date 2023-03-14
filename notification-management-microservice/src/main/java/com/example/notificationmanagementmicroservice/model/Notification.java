package com.example.notificationmanagementmicroservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Notification")
@Data
@NoArgsConstructor
public class Notification {
    @Id
    String id;
    @JsonProperty("userId")
    String userId;
    @JsonProperty("timestamp")
    String timestanmp;
    @JsonProperty("url")
    String url;
    @JsonProperty("message")
    String message;

}
