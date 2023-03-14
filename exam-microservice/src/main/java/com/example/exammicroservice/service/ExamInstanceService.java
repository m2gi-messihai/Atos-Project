package com.example.exammicroservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.management.Notification;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.exammicroservice.dto.QuestionDto;
import com.example.exammicroservice.dto.ExamInstanceDto;
import com.example.exammicroservice.dto.ExamQuestionDto;
import com.example.exammicroservice.dto.GetAssignedExamNameDto;
import com.example.exammicroservice.dto.NotificationDto;
import com.example.exammicroservice.model.ExamDefinition;
import com.example.exammicroservice.model.ExamInstance;
import com.example.exammicroservice.model.ExamQuestion;
import com.example.exammicroservice.model.GeneratedLink;
import com.example.exammicroservice.model.StatusEnum;
import com.example.exammicroservice.repository.ExamDefinitionRepository;
import com.example.exammicroservice.repository.ExamInstanceRepository;
import com.example.exammicroservice.webclientApi.WebClientApi;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class ExamInstanceService {
    private KafkaTemplate<String, Object> kafkaTemplate;
    private Logger log = LoggerFactory.getLogger(ExamInstanceService.class);
    @Autowired
    private ExamInstanceRepository examInstanceRepository;
    @Autowired
    private ExamDefinitionRepository examDefinitionRepository;
    @Autowired
    private WebClientApi webClientApi;
    @Autowired
    private ModelMapper modelMapper;

    public ExamInstanceService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

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
        kafkaTemplate.send("notification", examInstance.getExamInstanceId(),
                new NotificationDto(examInstance.getTakenBy(),
                        new Date().toString(), examInstance.getGeneratedLink().getUrl(),
                        "Exam is assgned"));
        return examInstanceRepository.save(examInstance);
    }

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
                    assignedExams.get(i).getDuration(), null, null);
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
        List<ExamQuestionDto> questions = new ArrayList<>();
        Integer sumDuration = 0;
        GetAssignedExamNameDto getAssignedExamNameDto = new GetAssignedExamNameDto();
        Optional<ExamInstance> examInstance = examInstanceRepository.findById(id);
        ExamInstanceDto examInstanceDto = modelMapper.map(examInstance, ExamInstanceDto.class);
        if (examInstance.isPresent()) {
            Optional<ExamDefinition> examDefinition = examDefinitionRepository
                    .findById(examInstance.get().getExamDefinitionId());
            if (examDefinition.isPresent()) {
                for (int i = 0; i < examInstanceDto.getExamQuestions().size(); i++) {
                    questions.add(examInstanceDto.getExamQuestions().get(i));
                }
                for (int i = 0; i < questions.size(); i++) {
                    sumDuration = sumDuration + Integer.parseInt(questions.get(i).getDisplayTime());

                }
                examInstanceDto.setDuration(sumDuration.toString());

                examInstanceRepository.save(modelMapper.map(examInstanceDto, ExamInstance.class));

                getAssignedExamNameDto = new GetAssignedExamNameDto(examInstanceDto.getExamInstanceId(),
                        examDefinition.get().getName(), examInstance.get().getStartedTime(),
                        examInstanceDto.getStartedTime(), questions);
            }
        }
        return getAssignedExamNameDto;

    }

    public ExamInstance setStartedTime(String id, ObjectNode json) {
        String date = json.get("startTime").asText();

        Optional<ExamInstance> examInstance = examInstanceRepository.findById(id);
        ExamInstanceDto examInstanceDto = modelMapper.map(examInstance.get(), ExamInstanceDto.class);
        if (examInstance.isPresent()) {
            examInstanceDto.setStartedTime(date);

            return examInstanceRepository.save(modelMapper.map(examInstanceDto, ExamInstance.class));
        } else {
            return null;
        }
    }

    public ExamInstance takeExam(String examId, String questionId, ObjectNode json) {
        String selectedAnswer = json.get("selectedAnswer").asText();
        String answerTime = json.get("answerTime").asText();
        Optional<ExamInstance> examInstance = examInstanceRepository.findById(examId);
        if (examInstance.isPresent()) {
            ExamInstanceDto examInstanceDto = modelMapper.map(examInstance.get(), ExamInstanceDto.class);
            for (int i = 0; i < examInstanceDto.getExamQuestions().size(); i++) {

                if (examInstanceDto.getExamQuestions().get(i).getQuestionId().equals(questionId)) {
                    examInstanceDto.getExamQuestions().get(i).setSelectedAnswerId(selectedAnswer);
                    examInstanceDto.getExamQuestions().get(i).setAnswerTime(answerTime);
                }
            }
            examInstanceDto.setStatus(StatusEnum.PRESENT);
            return examInstanceRepository.save(modelMapper.map(examInstanceDto, ExamInstance.class));
        } else {
            return null;
        }
    }

    public ExamInstance submitExam(String examId, String completionTime) {
        Optional<ExamInstance> examInstance = examInstanceRepository.findById(examId);
        if (examInstance.isPresent()) {
            ExamInstanceDto examInstanceDto = modelMapper.map(examInstance
                    .get(), ExamInstanceDto.class);
            examInstanceDto.setEndTime(completionTime);
            kafkaTemplate.send("notification", examInstanceDto.getExamInstanceId(),
                    new NotificationDto(examInstanceDto.getTakenBy(),
                            new Date().toString(), examInstanceDto.getGeneratedLink().getUrl(),
                            "Exam is submitted"));

            return examInstanceRepository.save(modelMapper.map(examInstanceDto, ExamInstance.class));
        } else {
            return null;
        }
    }
}
