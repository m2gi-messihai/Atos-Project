package com.vega.api.services;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vega.api.dto.GetAllQuestionsResponseDto;
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

    public Optional<Question> read(String id) {
        return questionRepository.findById(id);
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public void deleteQuestion(String id) {
        questionRepository.deleteById(id);
    }
    //

    public Question addNewAnswer(String id, Answer[] answers) {
        Optional<Question> existingQuestion = questionRepository.findById(id);
        log.debug("existing question " + existingQuestion.get().toString());
        if (existingQuestion.isPresent()) {
            existingQuestion.get().setAnswers(answers);
            return questionRepository.save(existingQuestion.get());
        }
        return null;

    }

    public GetAllQuestionsResponseDto getPaginatedQuestions(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Question> questions = questionRepository.findAll(pageable);
        List<Question> listOfQuestions = questions.getContent();
        List<Question> content = listOfQuestions.stream().collect(Collectors.toList());
        GetAllQuestionsResponseDto postResponse = new GetAllQuestionsResponseDto();
        postResponse.setQuestions(content);
        postResponse.setPageNumber(questions.getNumber());
        postResponse.setPageSize(questions.getSize());
        postResponse.setTotalQuestions(questions.getTotalElements());
        postResponse.setTotalPages(questions.getTotalPages());
        postResponse.setLast(questions.isLast());
        return postResponse;

    }

}
