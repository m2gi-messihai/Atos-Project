import { Component, OnInit } from '@angular/core';
import { Answer } from '../interfaces/Answer';
import { Question } from '../interfaces/Question';
import { AnswerService } from '../services/answer.service';
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
  choices: Answer[] | null = null;
  constructor(public questionService: QuestionService, public answerService: AnswerService, private dialog: MatDialog) { }
  addAnswer() {
    const dialogRef = this.dialog.open(AddAnswerPopupComponent)
  }
  addQuestion() {

  }
  ngOnInit(): void {
    this.questionService.fetchQuestions().subscribe(data => {
      this.questionList = data;

    });
  }

}
//TODO
//Rename interfaces to models
//Add client folder to do api calls 
//service calls the client
//SOLID revision
