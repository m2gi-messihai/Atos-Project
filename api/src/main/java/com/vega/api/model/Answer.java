package com.vega.api.model;

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

    private String id;
    @NonNull
    private String name;
    @NonNull
    private String description;

}
