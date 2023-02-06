package com.vega.api.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vega.api.model.Question;
import com.vega.api.repository.QuestionRepository;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("")
    public List<Question> list() {
        return questionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Question> read(@PathVariable ObjectId id) {
        return questionRepository.findById(id);
    }

    @PostMapping("")
    public Question createQuestion(@ModelAttribute Question question) {
        return questionRepository.save(question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable ObjectId id) {
        questionRepository.deleteById(id);
    }

}
