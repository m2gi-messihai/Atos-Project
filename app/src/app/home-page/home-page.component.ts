import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ExamDefinition } from '../models/ExamDefinition';
import { ExamDefinitionService } from '../services/exam-definition.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  exams: ExamDefinition[] | null = null;

  constructor(private router: Router, public examDefinitionService: ExamDefinitionService) { }
  ngOnInit(): void {
    this.examDefinitionService.getExamDefinition().subscribe((res => {
      this.exams = res;
    }));
  }
  examPage(examId: string) {
    this.router.navigate([`/${examId}`])

  }

}
