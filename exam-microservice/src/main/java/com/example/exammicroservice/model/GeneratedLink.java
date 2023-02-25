package com.example.exammicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeneratedLink {
    String scheduledTimeFrom;
    String scheduledTimeTo;
    String token;
    String url;

}
