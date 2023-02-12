import { Component, OnInit } from '@angular/core';
import { Question } from '../models/Question';
import { QuestionService } from '../services/question.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Level } from '../models/Level';
import { Type } from '../models/Type';

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})

export class AddQuestionComponent implements OnInit {
  questionForm: FormGroup

  submitted = false;


  constructor(public questionService: QuestionService, private fb: FormBuilder, private router: Router) {
    this.questionForm = this.fb.group({
      name: ['', [Validators.required]],
      levelId: ['', [Validators.required]],
      typeId: ['', [Validators.required]],
      category: ['', [Validators.required]],
      subCategory: ['', [Validators.required]],
      mark: ['', [Validators.required]],
      expectedTime: ['', [Validators.required]],
      createdBy: ['', [Validators.required]],
      createdAt: ['', [Validators.required]]

    }
    )
  }
  selectedLevel: string = '';
  selectedType: string = '';

  levels: Level[] = [
    { id: '1', body: 'level1' },
    { id: '2', body: 'level2' },
    { id: '3', body: 'level3' }
  ];

  types: Type[] = [
    { id: '1', body: 'type1' },
    { id: '2', body: 'type2' },
    { id: '3', body: 'type3' }
  ];


  ngOnInit(): void {
  }
  onSubmit(question: Question) {
    this.questionService.createQuestion(question);
    this.router.navigate([''])

  }

}
