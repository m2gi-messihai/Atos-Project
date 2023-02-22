import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ExamDefinition } from '../models/ExamDefinition';
import { ExamDefinitionService } from '../services/exam-definition.service';

@Component({
  selector: 'app-exam-page',
  templateUrl: './exam-page.component.html',
  styleUrls: ['./exam-page.component.css']
})
export class ExamPageComponent implements OnInit {
  exam: ExamDefinition | null = null;


  constructor(private route: ActivatedRoute, private examDefinitionService: ExamDefinitionService) { }

  ngOnInit(): void {
    const examId = this.route.snapshot.paramMap.get('examId');
    console.log(examId)
    if (examId) {
      this.examDefinitionService.getExamDefinitionById(examId).subscribe((res) => {
        this.exam = res;
      });

    }

  }

}
