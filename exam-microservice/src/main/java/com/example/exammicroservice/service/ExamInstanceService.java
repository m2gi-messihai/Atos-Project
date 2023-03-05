package com.example.exammicroservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exammicroservice.dto.QuestionDto;
import com.example.exammicroservice.dto.ExamInstanceDto;
import com.example.exammicroservice.dto.GetAssignedExamNameDto;
import com.example.exammicroservice.model.ExamDefinition;
import com.example.exammicroservice.model.ExamInstance;
import com.example.exammicroservice.model.ExamQuestion;
import com.example.exammicroservice.model.StatusEnum;
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
    @Autowired
    private ModelMapper modelMapper;

    public ExamInstance assignExamToStudent(ExamInstance examInstance) {

        String examDefinitionId = examInstance.getExamDefinitionId();
        List<ExamQuestion> examQuestions = new ArrayList<>();

        Optional<ExamDefinition> examDefinition = examDefinitionRepository
                .findById(examDefinitionId);
        if (examDefinition.isPresent()) {
            List<String> examIds = examDefinition.get().getQuestionsIds();
            List<QuestionDto> questions = getQuestionsByIds(examIds);
            for (int i = 0; i < examIds.size(); i++) {
                ExamQuestion examQuestion = new ExamQuestion(getQuestions(examIds.get(i))
                        .getKey(), null,
                        getQuestions(examIds.get(i)).getExpectedTime(), null);
                examQuestions.add(examQuestion);
            }
            examInstance.setStatus(StatusEnum.ASSIGNED);
            examInstance.setExamQuestions(examQuestions);
        }
        return examInstanceRepository.save(examInstance);
    }
    // get question tak all questionsIds and retur all questionsDetails

    public QuestionDto getQuestions(String id) {
        return webClientApi.getQuestionById(id);
    }

    public List<QuestionDto> getQuestionsByIds(List<String> ids) {
        return webClientApi.getQuestionsByIds(ids);
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
                    assignedExams.get(i).getDuration(), null);
            getAssignedExamNameDtos.add(getAssignedExamNameDto);

        }
        return getAssignedExamNameDtos;

    }

    public QuestionDto getQuestionForExam(String examId, String questionId) {
        Optional<ExamInstance> examInstance = examInstanceRepository.findById(examId);
        for (int i = 0; i < examInstance.get().getExamQuestions().size(); i++) {
            if (examInstance.get().getExamQuestions().get(i).getQuestionId() == questionId)
                break;
        }
        return getQuestions(questionId);
    }

    public GetAssignedExamNameDto getAssignedExamById(String id) {
        List<String> questions = new ArrayList<>();
        GetAssignedExamNameDto getAssignedExamNameDto = new GetAssignedExamNameDto();
        Optional<ExamInstance> examInstance = examInstanceRepository.findById(id);
        if (examInstance.isPresent()) {
            Optional<ExamDefinition> examDefinition = examDefinitionRepository
                    .findById(examInstance.get().getExamDefinitionId());
            if (examDefinition.isPresent()) {
                for (int i = 0; i < examDefinition.get().getQuestionsIds().size(); i++) {
                    questions.add(examDefinition.get().getQuestionsIds().get(i));
                }
                getAssignedExamNameDto = new GetAssignedExamNameDto(examInstance.get().getExamInstanceId(),
                        examDefinition.get().getName(), examInstance.get().getDuration(), questions);
            }
        }
        return getAssignedExamNameDto;

    }

    public ExamInstance setStartedTime(String id, String date) {
        Optional<ExamInstance> examInstance = examInstanceRepository.findById(id);
        if (examInstance.isPresent()) {

            examInstance.get().setStartedTime(date);
            ExamInstanceDto examInstanceDto = modelMapper.map(examInstance.get(), ExamInstanceDto.class);
            return examInstanceRepository.save(examInstance.get());

        } else {
            return null;
        }
    }
    // public getExamQuestionById(String id, )

}
