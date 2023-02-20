import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ExamDefinition } from '../models/ExamDefinition';
import { ExamDefinitionService } from '../services/exam-definition.service';

@Component({
  selector: 'app-exam-form',
  templateUrl: './exam-form.component.html',
  styleUrls: ['./exam-form.component.css']
})
export class ExamFormComponent implements OnInit {

  examForm: FormGroup;

  constructor(private router: Router, private fb: FormBuilder, private examDefinitionService: ExamDefinitionService) {
    this.examForm = this.fb.group({
      name: ['', [Validators.required]],
      passingScore: ['', [Validators.required]],


    })
  }

  ngOnInit(): void {
  }
  onSubmit(exam: ExamDefinition) {
    this.examDefinitionService.createExamDefinition(exam).subscribe((res) => {
      this.router.navigate([''])
    })

  }

}
