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
  questionList: Question[] | null = null;
  answers: Answer[] | null = null;
  getAllQuestionsResponseDto?: GetAllQuestionsRsponseDto;
  constructor(public questionService: QuestionService) { }
  showBlock: Boolean[] = new Array(this.questionList?.length).fill(false);
  pageSlice = this.questionList?.slice(0.3);
  pageSize: number[] = [3, 6, 9]
  currentPageSize: number = 3;
  pageNumber: number = 0;



  addAnswer(i: number) {

    if (this.showBlock[i]) {
      this.showBlock[i] = false
    }
    else {
      this.showBlock[i] = true;
    }

  }
  onPageChange(event: PageEvent) {
    console.log(event)
    this.currentPageSize = event.pageSize;
    this.pageNumber = event.pageIndex;
    this.questionService.fetchPaginatedQuestions(this.pageNumber, this.currentPageSize).subscribe(data => {
      this.getAllQuestionsResponseDto = data
      console.log(this.getAllQuestionsResponseDto);

    })

  }

  ngOnInit(): void {

    this.questionService.fetchPaginatedQuestions(this.pageNumber, this.currentPageSize).subscribe(data => {
      this.getAllQuestionsResponseDto = data
      console.log(this.getAllQuestionsResponseDto);

    })
  }
  deleteQuestion(id: String) {
    this.questionService.deleteQuestion(id)
  }

}


