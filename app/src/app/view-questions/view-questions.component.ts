import { Component, OnInit } from '@angular/core';
import { Answer } from '../models/Answer';
import { Question } from '../models/Question';
import { AnswerService } from '../services/answer.service';
import { QuestionService } from '../services/question.service';
import { MatDialog } from '@angular/material/dialog';



@Component({
  selector: 'app-view-questions',
  templateUrl: './view-questions.component.html',
  styleUrls: ['./view-questions.component.css']
})
export class ViewQuestionsComponent implements OnInit {
  questionList: Question[] | null = null;
  choices: Answer[] | null = null;
  showBlock: Boolean[] = new Array(this.questionList?.length).fill(false);

  constructor(public questionService: QuestionService, public answerService: AnswerService, private dialog: MatDialog) { }

  addAnswer(i: number) {

    if (this.showBlock[i]) {
      this.showBlock[i] = false
    }
    else {
      this.showBlock[i] = true;
    }

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
