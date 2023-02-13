package com.vega.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import com.mongodb.lang.NonNull;

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
