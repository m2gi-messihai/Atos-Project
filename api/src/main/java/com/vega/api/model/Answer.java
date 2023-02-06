package com.vega.api.model;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Answer {

    @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String description;

}
