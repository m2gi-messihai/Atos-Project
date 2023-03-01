import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Question } from '../models/Question';
import { ExamInstanceService } from '../services/exam-instance.service';

@Component({
  selector: 'app-take-exam',
  templateUrl: './take-exam.component.html',
  styleUrls: ['./take-exam.component.css']
})
export class TakeExamComponent implements OnInit {
  examId: string | null = null;
  questionId: string | null = null;
  question: Question | null = null;

  constructor(public examInstanceService: ExamInstanceService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.examId = this.route.snapshot.paramMap.get('examId');
    this.questionId = this.route.snapshot.paramMap.get('questionId');
    if (this.examId && this.questionId) {
      this.examInstanceService.getQuestionForExam(this.examId, this.questionId).subscribe((res) => {
        console.log(res);
        this.question = res;
      })
    }

  }

}
