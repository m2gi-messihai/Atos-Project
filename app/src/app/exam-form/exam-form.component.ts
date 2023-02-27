import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { AddQuestionsPopupComponent } from '../add-questions-popup/add-questions-popup.component';
import { ExamDefinition } from '../models/ExamDefinition';
import { ExamDefinitionService } from '../services/exam-definition.service';

@Component({
  selector: 'app-exam-form',
  templateUrl: './exam-form.component.html',
  styleUrls: ['./exam-form.component.css']
})
export class ExamFormComponent implements OnInit {

  examForm: FormGroup;
  // exam: ExamDefinition | null = null;
  questionIds: string[] | null = null;


  constructor(private router: Router, private fb: FormBuilder, private examDefinitionService: ExamDefinitionService, public dialog: MatDialog) {
    this.examForm = this.fb.group({
      name: ['', [Validators.required]],
      passingScore: ['', [Validators.required]],


    })
  }
  addQuestionForm() {
    let dialoRef = this.dialog.open(AddQuestionsPopupComponent, { disableClose: true })
    dialoRef.afterClosed().subscribe((res) => {
      this.questionIds = res.data;

    })
  }

  ngOnInit(): void {
  }
  onSubmit(exam: ExamDefinition) {
    exam.name = this.examForm.value.name;
    exam.passingScore = this.examForm.value.passingScore;
    if (this.questionIds) {
      exam.questionsIds = this.questionIds;
      console.log(this.questionIds);
    }
    this.examDefinitionService.createExamDefinition(exam).subscribe((res) => {


    })

  }

}
