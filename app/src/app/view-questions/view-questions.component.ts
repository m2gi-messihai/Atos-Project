import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Answer } from '../models/Answer';
import { GetAllQuestionsRsponseDto } from '../models/GetAllQuestionsResponseDto';
import { Question } from '../models/Question';

import { QuestionService } from '../services/question.service';

@Component({
  selector: 'app-view-questions',
  templateUrl: './view-questions.component.html',
  styleUrls: ['./view-questions.component.css']
})
export class ViewQuestionsComponent implements OnInit {
  questions: Question[] | null = null;
  totalQuestionsCount: number = 0;
  constructor(public questionService: QuestionService) { }
  pageSize: number[] = [3, 6, 9]
  currentPageSize: number = 3;
  pageNumber: number = 0;

  editingQuestionKey: string | null = null

  addAnswer(key: string) {
    this.editingQuestionKey = key;
  }
  onPageChange(event: PageEvent) {
    this.fetchQuestions(event.pageIndex, event.pageSize)

  }

  ngOnInit(): void {
    this.fetchQuestions(this.pageNumber, this.currentPageSize);
  }

  deleteQuestion(key: string, index: number) {
    this.questionService.deleteQuestion(key).subscribe(data => {
      this.questions = this.questions ? this.questions.filter(question => question.key !== key) : null;
    })

  }

  fetchQuestions(pageNumber: number, pageSize: number) {
    this.questionService.fetchPaginatedQuestions(pageNumber, pageSize).subscribe(data => {
      this.questions = data.questions
      this.totalQuestionsCount = data.totalQuestions;
      this.currentPageSize = data.pageSize;
      this.pageNumber = data.pageNumber;
    })
  }

}


