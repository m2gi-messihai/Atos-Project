import { Component, OnInit } from '@angular/core';
import { MatRadioChange } from '@angular/material/radio';
import { ActivatedRoute, Router } from '@angular/router';
import { ExamQuestion } from '../models/ExamQuestion';

import { Question } from '../models/Question';
import { ExamInstanceService } from '../services/exam-instance.service';
import * as dayjs from 'dayjs';
import { GetAssignedExamNameDto } from '../models/GetAssignedExam';

@Component({
  selector: 'app-take-exam',
  templateUrl: './take-exam.component.html',
  styleUrls: ['./take-exam.component.css']
})
export class TakeExamComponent implements OnInit {
  examId: string | null = null;
  currentQuestionId: string | null = null;
  currentQuestion: ExamQuestion | null = null;
  questions: ExamQuestion[] | null = null;
  question: Question | null = null;
  examState: boolean = false;
  getAssignedExamNameDto: GetAssignedExamNameDto | false = false;

  second: string | null = null;
  polling: any;

  constructor(private router: Router, public examInstanceService: ExamInstanceService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.examId = this.route.snapshot.paramMap.get('examId');
    this.currentQuestionId = this.route.snapshot.paramMap.get('questionId');

    if (this.examId && this.currentQuestionId) {
      this.examInstanceService.getAssignedExamById(this.examId).subscribe((res) => {
        this.getAssignedExamNameDto = res;

      });
      this.examInstanceService.getAssignedExamById(this.examId).subscribe((res) => {
        this.questions = res.questions;
        console.log(this.questions);
        if (this.questions) {
          this.questions.forEach((question) => {
            if (question.questionId === this.currentQuestionId) {
              this.currentQuestion = question;
              this.changeQuestion(this.examId, this.currentQuestion);
            }
          })
        }

      })
    }
  }
  ngOnDestroy() {

    clearInterval(this.polling);

  }
  answerValue(event: MatRadioChange) {
    console.log(event.value.name);
    if (this.currentQuestion)
      this.currentQuestion.selectedAnswerId = event.value.name;
  }
  saveAnswer() {
    if (this.examId && this.currentQuestion && this.currentQuestionId)
      this.examInstanceService.takeExam(this.examId, this.currentQuestionId, this.currentQuestion.selectedAnswerId).subscribe((res) => {
        console.log(res);
      })
  }

  nextQuestion() {

    this.saveAnswer();
    if (this.questions?.length === 0) {
      this.router.navigate([""]);
      if (this.examId)
        this.examInstanceService.submitExam(this.examId, dayjs().format("DD/MM/YY,HH:mm")).subscribe()
    }
    else {
      const nextQuestion = this.questions?.pop();
      if (nextQuestion) {
        this.changeQuestion(this.examId, nextQuestion);
        this.currentQuestionId = nextQuestion.questionId;
      }
      this.router.navigate([`assignedExam/${this.examId}/questions/${nextQuestion?.questionId}`]);

    }

  }

  changeQuestion(examId: string | null, question: ExamQuestion | null) {

    clearInterval(this.polling);

    if (examId && question) {

      if (this.questions?.length === 0) {
        console.log("no question")
        this.examState = true;

      }
      else {
        this.timer(1, Number(question.displayTime));
        this.examInstanceService.getQuestionForExam(examId, question.questionId).subscribe((res) => {

          this.question = res;
        })
      }


    }
  }

  submitExam() {
    this.saveAnswer();
    if (this.examId)
      this.examInstanceService.submitExam(this.examId, dayjs().format("DD/MM/YY,HH:mm")).subscribe();
    this.router.navigate([""]);
  }
  timer(minute: number, displayTime: number) {
    // let minute = 1;
    let seconds: number = minute * displayTime;
    let textSec: any = "0";
    let statSec: number = displayTime;

    const prefix = minute < 10 ? "0" : "";

    this.polling = setInterval(() => {
      seconds--;
      if (statSec != 0) statSec--;
      else {
        statSec = displayTime;

      }

      if (statSec < 10) {
        textSec = "0" + statSec;
      } else textSec = statSec;

      this.second = `${prefix}${Math.floor(seconds / 60)}:${textSec}`;

      if (seconds == 0) {
        console.log("finished");
        clearInterval(this.polling);
        this.nextQuestion()

      }

    }, 1000);
  }
}
