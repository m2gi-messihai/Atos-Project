package com.example.exammicroservice.model;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.exammicroservice.dto.ExamQuestionDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection = "ExamInstance")
@Data
@AllArgsConstructor
public class ExamInstance {
    @Id
    String examInstanceId;
    String examDefinitionId;
    String startedTime;// take exam
    String endTime;// submit
    String duration;// check if user exceeded duration(calculated)
    String completionTime;// submit exam calsulated
    GeneratedLink generatedLink;//
    String createdBy;//
    String takenBy;
    StatusEnum status;// take exam set initially null or assigned
    List<ExamQuestion> examQuestions;// take exam

}
