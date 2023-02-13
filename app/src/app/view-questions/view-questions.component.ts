import { Component, OnInit } from '@angular/core';
import { Answer } from '../models/Answer';
import { Question } from '../models/Question';

import { QuestionService } from '../services/question.service';




@Component({
  selector: 'app-view-questions',
  templateUrl: './view-questions.component.html',
  styleUrls: ['./view-questions.component.css']
})
export class ViewQuestionsComponent implements OnInit {
  questionList: Question[] | null = null;
  answers: Answer[] | null = null;
  constructor(public questionService: QuestionService) { }
  showBlock: Boolean[] = new Array(this.questionList?.length).fill(false);

  addAnswer(i: number) {

    if (this.showBlock[i]) {
      this.showBlock[i] = false
    }
    else {
      this.showBlock[i] = true;
    }

  }

  ngOnInit(): void {
    this.questionService.fetchQuestions().subscribe(data => {
      this.questionList = data;

    });
  }
  // ngOnInit(): void {
  //   this.questionService.fetchQuestions();
  // }
  deleteQuestion(id: String) {
    this.questionService.deleteQuestion(id)

  }

}

