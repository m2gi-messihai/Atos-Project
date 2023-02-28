package com.example.exammicroservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exammicroservice.dto.QuestionDto;
import com.example.exammicroservice.dto.GetAssignedExamNameDto;
import com.example.exammicroservice.model.ExamDefinition;
import com.example.exammicroservice.model.ExamInstance;
import com.example.exammicroservice.model.ExamQuestion;
import com.example.exammicroservice.repository.ExamDefinitionRepository;
import com.example.exammicroservice.repository.ExamInstanceRepository;
import com.example.exammicroservice.webclientApi.WebClientApi;

@Service
public class ExamInstanceService {
    private Logger log = LoggerFactory.getLogger(ExamInstanceService.class);
    @Autowired
    private ExamInstanceRepository examInstanceRepository;
    @Autowired
    private ExamDefinitionRepository examDefinitionRepository;
    @Autowired
    private WebClientApi webClientApi;

    public ExamInstance assignExamToStudent(ExamInstance examInstance) {

        String examDefinitionId = examInstance.getExamDefinitionId();
        List<ExamQuestion> examQuestions = new ArrayList<>();
        Optional<ExamDefinition> examDefinition = examDefinitionRepository.findById(examDefinitionId);
        if (examDefinition.isPresent()) {
            String[] examIds = examDefinition.get().getQuestionsIds();

            for (int i = 0; i < examIds.length; i++) {

                ExamQuestion examQuestion = new ExamQuestion(getQuestions(examIds[i]).getKey(), null,
                        getQuestions(examIds[i]).getExpectedTime(), null);
                examQuestions.add(examQuestion);
            }
            examInstance.setExamQuestions(examQuestions);
        }
        return examInstanceRepository.save(examInstance);
    }

    public QuestionDto getQuestions(String id) {
        return webClientApi.getQuestionById(id);
    }

    public List<ExamInstance> getAssignedExam() {
        return examInstanceRepository.findAll();
    }

    public List<GetAssignedExamNameDto> getAssignedExamName() {

        List<GetAssignedExamNameDto> getAssignedExamNameDtos = new ArrayList<>();
        List<ExamInstance> assignedExams = this.getAssignedExam();
        for (int i = 0; i < assignedExams.size(); i++) {
            Optional<ExamDefinition> examDefinition = examDefinitionRepository
                    .findById(assignedExams.get(i).getExamDefinitionId());
            GetAssignedExamNameDto getAssignedExamNameDto = new GetAssignedExamNameDto(
                    assignedExams.get(i).getExamInstanceId(), examDefinition.get().getName(),
                    assignedExams.get(i).getDuration());
            getAssignedExamNameDtos.add(getAssignedExamNameDto);

        }
        return getAssignedExamNameDtos;

    }

}
