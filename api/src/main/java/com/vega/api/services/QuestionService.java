package com.vega.api.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.vega.api.model.Question;
import com.vega.api.repository.QuestionRepository;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;

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

    public Question editQuestion(ObjectId id, Map<String, Object> fields) {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Question.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, question.get(), value);
            });
            return questionRepository.save(question.get());
        }
        return null;
    }

}
