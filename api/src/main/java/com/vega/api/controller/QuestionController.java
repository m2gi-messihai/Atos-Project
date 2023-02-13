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
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("")
    public List<Question> list() {
        return questionService.list();
    }

    @GetMapping("/{id}")
    public Optional<Question> read(@PathVariable ObjectId id) {
        return questionService.read(id);
    }

    @PostMapping("")
    public Question createQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable String id) {
        log.debug("id equal " + id);
        questionService.deleteQuestion(id);

    }

    @PatchMapping("/{id}")
    public Question editQuestion(@PathVariable String id, @RequestBody Answer[] answers) {
        return questionService.editQuestion(id, answers);

    }

}
// TODO
// add data transfer object
// add services
// Search database constraints using spring data /nonnull annotation in entities
// RequestBody and model attributes
// Spring Feature and lauching steps (dependency injection...)
// mongo template
// ORM concept
// spring core
// servelet
// database
// singleton design pattern
// MVC principle
// create new question
// list question pagination
// add answer for existing question
// rest api methods (ex:patch)
// URl configuarable
