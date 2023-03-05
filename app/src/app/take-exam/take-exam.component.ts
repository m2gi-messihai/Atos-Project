import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Question } from '../models/Question';
import { ExamInstanceService } from '../services/exam-instance.service';

@Component({
  selector: 'app-take-exam',
  templateUrl: './take-exam.component.html',
  styleUrls: ['./take-exam.component.css']
})
export class TakeExamComponent implements OnInit {
  examId: string | null = null;
  currentQuestionId: string | null = null;
  questionsIds: string[] | null = null;
  question: Question | null = null;

  constructor(private router: Router, public examInstanceService: ExamInstanceService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.examId = this.route.snapshot.paramMap.get('examId');
    this.currentQuestionId = this.route.snapshot.paramMap.get('questionId');
    if (this.examId && this.currentQuestionId) {
      this.examInstanceService.getAssignedExamById(this.examId).subscribe((res) => {
        this.questionsIds = res.questionsIds;
      })
    }
    this.changeQuestion(this.examId, this.currentQuestionId);

  }
  nextQuestion() {
    const nextQuestion = this.questionsIds?.pop();
    console.log(nextQuestion);
    if (nextQuestion !== this.currentQuestionId) {
      if (nextQuestion) { this.changeQuestion(this.examId, nextQuestion) }

      this.router.navigate([`assignedExam/${this.examId}/questions/${nextQuestion}`]);
    }

  }
  changeQuestion(examId: string | null, questionId: string | null) {
    if (examId && questionId) {
      this.examInstanceService.getQuestionForExam(examId, questionId).subscribe((res) => {
        console.log(res);
        this.question = res;
      })
      if (this.questionsIds?.length === 1) {
        console.log("last question")
      }
    }
  }
  lastItemInMap(array: string[] | null) {
    return array?.pop();
  }
}
