package com.vega.api.model;

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
    @NonNull
    private String name;
    @Field("level_id")
    @NonNull
    private String levelId;
    @Field("type_id")
    @NonNull
    private String typeId;
    @Field
    @NonNull
    private String category;
    @Field("sub_category")
    @NonNull
    private String subCategory;
    @Field
    @NonNull
    private String mark;
    @Field("expected_time")
    @NonNull
    private String expectedTime;
    @Field
    @NonNull
    private String correctAnswerIds[];
    @Field("created_by")
    @NonNull
    private String createdBy;
    @Field
    @NonNull
    private String createdAt;
    @Field
    @NonNull
    private List<Answer> answers;

}
