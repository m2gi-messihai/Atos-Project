import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExamDefinition } from '../models/ExamDefinition';
import { ExamDefinitionService } from '../services/exam-definition.service';

@Component({
  selector: 'app-exam-page',
  templateUrl: './exam-page.component.html',
  styleUrls: ['./exam-page.component.css']
})
export class ExamPageComponent implements OnInit {
  exam: ExamDefinition | null = null;
  examId: string | null = "";


  constructor(private route: ActivatedRoute, private examDefinitionService: ExamDefinitionService, private router: Router) { }

  ngOnInit(): void {

    this.examId = this.route.snapshot.paramMap.get('examId');
    console.log(this.examId)
    if (this.examId) {
      this.examDefinitionService.getExamDefinitionById(this.examId).subscribe((res) => {
        this.exam = res;
      });

    }

  }
  assignExam() {
    this.router.navigate([`/${this.examId}/assignExam`])

  }

}
