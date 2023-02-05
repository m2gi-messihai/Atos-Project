package com.vega.api.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Question {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String level_id;
    @NonNull
    private String type_id;
    @NonNull
    private String category;
    @NonNull
    private String sub_category;
    @NonNull
    private String mark;
    @NonNull
    private String expected_time;
    @NonNull
    private String correct_answer_ids[];
    @NonNull
    private String created_by;
    @NonNull
    private String created_at;
    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

}
