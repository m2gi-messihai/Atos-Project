import { Component, OnInit } from '@angular/core';
import { Answer } from '../models/Answer';
import { Question } from '../models/Question';

import { QuestionService } from '../services/question.service';
import { MatDialog } from '@angular/material/dialog';
import { AddAnswerPopupComponent } from '../add-answer-popup/add-answer-popup.component';


@Component({
  selector: 'app-view-questions',
  templateUrl: './view-questions.component.html',
  styleUrls: ['./view-questions.component.css']
})
export class ViewQuestionsComponent implements OnInit {
  questionList: Question[] | null = null;
  answers: Answer[] | null = null;
  constructor(public questionService: QuestionService, private dialog: MatDialog) { }
  answerForm(id: String) {
    const dialogRef = this.dialog.open(AddAnswerPopupComponent);
    dialogRef.afterClosed().subscribe(item => {
      console.log(item);

    })

  }
  ngOnInit(): void {
    this.questionService.fetchQuestions().subscribe(data => {
      this.questionList = data;

    });
  }
  deleteQuestion(id: String) {
    this.questionService.deleteQuestion(id)

  }

}
//TODO
//Rename interfaces to models
//Add client folder to do api calls 
//service calls the client
//SOLID revision
