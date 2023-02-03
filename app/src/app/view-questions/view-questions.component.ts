import { Component, OnInit } from '@angular/core';
import { Answer } from '../interfaces/Answer';

import { Question } from '../interfaces/Question';
import { QuestionService } from '../services/question.service';

@Component({
  selector: 'app-view-questions',
  templateUrl: './view-questions.component.html',
  styleUrls: ['./view-questions.component.css']
})
export class ViewQuestionsComponent implements OnInit {
  questionList: Question[] | null = null;
  choices: Answer[] | null = null;
  constructor(public questionService: QuestionService) { }

  ngOnInit(): void {
    this.questionService.fetchQuestions().subscribe(data => {
      this.questionList = data;

    });
  }

}
