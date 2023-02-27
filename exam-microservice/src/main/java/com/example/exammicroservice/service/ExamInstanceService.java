package com.example.exammicroservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.exammicroservice.model.ExamInstance;
import com.example.exammicroservice.model.ExamQuestion;
import com.example.exammicroservice.repository.ExamInstanceRepository;

@Service
public class ExamInstanceService {
    private Logger log = LoggerFactory.getLogger(ExamInstanceService.class);
    @Autowired
    private ExamInstanceRepository examInstanceRepository;

    public ExamInstance assignExamToStudent(ExamInstance examInstance) {

        return examInstanceRepository.save(examInstance);
    }

    public ExamInstance takeExam(String id, ExamQuestion[] newExamQuestion) {
        log.debug("------------------" + id);
        Optional<ExamInstance> examInstance = examInstanceRepository.findById(id);
        if (examInstance.isPresent()) {
            examInstance.get().setExamQuestions(newExamQuestion);
            return examInstanceRepository.save(examInstance.get());
        } else {
            return null;
        }

    }

    public List<ExamInstance> getAssignedExam() {
        return examInstanceRepository.findAll();
    }

}
