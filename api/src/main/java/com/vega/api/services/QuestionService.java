package com.vega.api.services;

import java.util.List;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import com.vega.api.model.Answer;
import com.vega.api.model.Question;
import com.vega.api.repository.QuestionRepository;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    private Logger log = LoggerFactory.getLogger(QuestionService.class);

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> list() {
        return questionRepository.findAll();

    }

    public Optional<Question> read(ObjectId id) {
        return questionRepository.findById(id);
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public void deleteQuestion(String id) {
        questionRepository.deleteById(id);
    }
    //

    public Question editQuestion(String id, Answer[] answers) {
        Optional<Question> existingQuestion = questionRepository.findById(id);
        log.debug("existing question " + existingQuestion.get().toString());
        if (existingQuestion.isPresent()) {
            existingQuestion.get().setAnswers(answers);
            return questionRepository.save(existingQuestion.get());
        }
        return null;

    }

}
// fields.forEach((key, value) -> {
// Field field = ReflectionUtils.findField(Question.class, key);
// field.setAccessible(true);
// ReflectionUtils.setField(field, question, value);
// });
// return questionRepository.save(question);
// questionRepository.deleteById(id);
