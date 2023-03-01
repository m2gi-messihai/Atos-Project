import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ExamDefinition } from '../models/ExamDefinition';
import { ExamInstance } from '../models/ExamInstance';
import { ExamQuestion } from '../models/ExamQuestion';
import { GetAssignedExamNameDto } from '../models/GetAssignedExam';
import { ExamDefinitionService } from '../services/exam-definition.service';
import { ExamInstanceService } from '../services/exam-instance.service';

@Component({
  selector: 'app-assigned-exams',
  templateUrl: './assigned-exams.component.html',
  styleUrls: ['./assigned-exams.component.css']
})
export class AssignedExamsComponent implements OnInit {
  assignedExams: GetAssignedExamNameDto[] | null = null;

  constructor(private router: Router, public examInstanceService: ExamInstanceService, public examDefinitionService: ExamDefinitionService) { }

  ngOnInit(): void {
    this.examInstanceService.getAssignedExams().subscribe((res) => {
      this.assignedExams = res;
      console.log(this.assignedExams);

    })
  }
  startExam(id: string) {
    this.router.navigate([`assignedExam/${id}`])


  }

}
