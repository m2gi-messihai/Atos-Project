import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExamQuestion } from '../models/ExamQuestion';
import { GetAssignedExamNameDto } from '../models/GetAssignedExam';
import { ExamInstanceService } from '../services/exam-instance.service';

@Component({
  selector: 'app-exam-initial-page',
  templateUrl: './exam-initial-page.component.html',
  styleUrls: ['./exam-initial-page.component.css']
})
export class ExamInitialPageComponent implements OnInit {
  examInstanceId: string | null = "";
  assignedExam: GetAssignedExamNameDto | null = null;
  url: string = "";

  constructor(private router: Router, private route: ActivatedRoute, public examInstanceService: ExamInstanceService) { }

  ngOnInit(): void {
    this.url = window.location.href;
    console.log(this.url);
    this.examInstanceId = this.route.snapshot.paramMap.get('id');
    console.log(this.examInstanceId);
    if (this.examInstanceId) {
      this.examInstanceService.getAssignedExamById(this.examInstanceId).subscribe((res) => {
        this.assignedExam = res;
        console.log(res);
      });
    }
  }
  startExam(examId: string, questions: ExamQuestion[]) {
    this.examInstanceService.startExam(examId, this.url).subscribe((res) => {
      this.router.navigate([`assignedExam/${examId}/questions/${questions[0].questionId}`]);
    });
  }
}
