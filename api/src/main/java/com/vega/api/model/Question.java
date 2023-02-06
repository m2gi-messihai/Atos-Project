package com.vega.api.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import org.bson.types.ObjectId;

@Document(collection = "Question")
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Question {
    @Id
    private ObjectId id;
    @Field
    @NonNull
    private String name;
    @Field
    @NonNull
    private String level_id;
    @Field
    @NonNull
    private String type_id;
    @Field
    @NonNull
    private String category;
    @Field
    @NonNull
    private String sub_category;
    @Field
    @NonNull
    private String mark;
    @Field
    @NonNull
    private String expected_time;
    @Field
    @NonNull
    private String correct_answer_ids[];
    @Field
    @NonNull
    private String created_by;
    @Field
    @NonNull
    private String created_at;
    @Field
    @NonNull
    private List<Answer> answers = new ArrayList<>();

}
