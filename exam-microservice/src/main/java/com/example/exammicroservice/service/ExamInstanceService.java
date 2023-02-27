package com.example.exammicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exammicroservice.model.ExamInstance;
import com.example.exammicroservice.model.GeneratedLink;
import com.example.exammicroservice.repository.ExamInstanceRepository;

@Service
public class ExamInstanceService {
    @Autowired
    private ExamInstanceRepository examInstanceRepository;

    public ExamInstance assignExamToStudent(ExamInstance examInstance) {

        return examInstanceRepository.save(examInstance);
    }

}
