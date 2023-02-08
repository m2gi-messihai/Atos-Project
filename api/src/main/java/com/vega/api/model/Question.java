package com.vega.api.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodb.lang.NonNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
    @Field("created_at")
    @NonNull
    private String createdAt;
    @NonNull
    private List<Answer> answers;

}
