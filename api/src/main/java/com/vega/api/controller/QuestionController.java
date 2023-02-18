package com.vega.api.controller;

import java.util.List;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vega.api.dto.GetAllQuestionsResponseDto;
import com.vega.api.model.Answer;
import com.vega.api.model.Question;
import com.vega.api.services.QuestionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/questions")
public class QuestionController {
    private Logger log = LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    private QuestionService questionService;

    @GetMapping("/{id}")
    public Optional<Question> read(@PathVariable ObjectId id) {
        return questionService.read(id);
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable String id) {
        log.debug("id equal " + id);
        questionService.deleteQuestion(id);

    }

    @PatchMapping("/{id}")
    public Question addNewAnswer(@PathVariable String id, @RequestBody Answer[] answers) {
        return questionService.addNewAnswer(id, answers);

    }

    @GetMapping
    public GetAllQuestionsResponseDto getAllPosts(
            @RequestParam(value = "pageNumber") Integer pageNumber,
            @RequestParam(value = "pageSize") Integer pageSize

    ) {
        return questionService.getPaginatedQuestions(pageNumber, pageSize);
    }

}