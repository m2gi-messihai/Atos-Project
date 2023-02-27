import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ExamDefinition } from '../models/ExamDefinition';
import { ExamInstance } from '../models/ExamInstance';
import { ExamQuestion } from '../models/ExamQuestion';
import { ExamDefinitionService } from '../services/exam-definition.service';
import { ExamInstanceService } from '../services/exam-instance.service';

@Component({
  selector: 'app-assigned-exams',
  templateUrl: './assigned-exams.component.html',
  styleUrls: ['./assigned-exams.component.css']
})
export class AssignedExamsComponent implements OnInit {
  assignedExams: ExamInstance[] | null = null;
  assigneExamsName: string[] = new Array();
  examQuestions: ExamQuestion[] = new Array();
  examQuestion: ExamQuestion | null = null;
  questionIds: string[] | null = null;
  assigneExamDefinition: ExamDefinition | null = null;

  constructor(private router: Router, public examInstanceService: ExamInstanceService, public examDefinitionService: ExamDefinitionService) { }

  ngOnInit(): void {
    this.examInstanceService.getAssignedExams().subscribe((res) => {
      this.assignedExams = res;
      console.log(this.assignedExams);

    })
  }

  takeExam(exam: ExamInstance) {
    console.log(exam.examInstanceId);
    this.examDefinitionService.getExamDefinitionById(exam.examDefinitionId).subscribe((res) => {
      this.assigneExamDefinition = res;
      this.questionIds = this.assigneExamDefinition.questionsIds;
      console.log(this.questionIds);
      this.questionIds.forEach((questionId) => {
        this.examQuestion = {
          questionId: questionId,
          selectedAnswerId: "",
          displayTime: "",
          answerTime: ""

        };
        this.examQuestions?.push(this.examQuestion);
        console.log(this.examQuestion);
      })

      if (this.examQuestions) {
        this.addQuestionId(exam.examInstanceId, this.examQuestions)
      }

    });
    this.router.navigate([`/takeExam/${exam.examInstanceId}`])
  }

  addQuestionId(id: string, questions: ExamQuestion[]) {
    this.examInstanceService.takeExam(id, questions).subscribe((res) => {
      console.log(res);
    })
  }
}
