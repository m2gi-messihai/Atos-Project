package com.vega.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodb.lang.NonNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Question")
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Question {

    private String id;
    @NonNull
    private String name;
    @Field("level_id")
    @NonNull
    private String levelId;
    @Field("type_id")
    @NonNull
    private String typeId;
    @Id
    @NonNull
    private String key;
    @NonNull
    private String category;
    @Field("sub_category")
    @NonNull
    private String subCategory;
    @NonNull
    private String mark;
    @Field("expected_time")
    private String expectedTime;
    @Field("correct_answer_ids")
    @NonNull
    private String correctAnswerIds[];
    @Field("created_by")
    @NonNull
    private String createdBy;
    @Field("created_at")
    @NonNull
    private String createdAt;
    private Answer[] answers;

}
