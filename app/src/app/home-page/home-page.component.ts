import { Component, OnInit } from '@angular/core';
import { ExamDefinition } from '../models/ExamDefinition';
import { ExamDefinitionService } from '../services/exam-definition.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  exams: ExamDefinition[] | null = null;

  constructor(public examDefinitionService: ExamDefinitionService) { }

  ngOnInit(): void {
    this.examDefinitionService.getExamDefinition().subscribe((res => {
      this.exams = res;
    }));

  }

}
