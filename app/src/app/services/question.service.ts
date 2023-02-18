import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, map } from 'rxjs';
import { Client } from '../clients/client';
import { ErrorPopupComponent } from '../error-popup/error-popup.component';
import { Answer } from '../models/Answer';
import { GetAllQuestionsRsponseDto } from '../models/GetAllQuestionsResponseDto';
import { Question } from '../models/Question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  API = 'http://localhost:8080/questions';
  constructor(private http: HttpClient, public dialog: MatDialog) { }
  fetchQuestions() {
    return this.http
      .get<{ [key: string]: Question }>(
        this.API
      )
      .pipe(
        map((res) => {
          const questions = [];
          for (const key in res) {
            if (res.hasOwnProperty(key)) {
              questions.push({ ...res[key], id: key });
            }
          }
          return questions;
        })
      );
  }
  fetchPaginatedQuestions(offset: number, pageSize: number) {
    return this.http.get<GetAllQuestionsRsponseDto>(
      this.API + '?pageNumber=' + offset + '&pageSize=' + pageSize
    );
  }

  deleteQuestion(id: String) {
    console.log(id);
    return this.http.delete(this.API + "/" + id).pipe(catchError(this.handleError));
  }
  createQuestion(question: Question) {
    return this.http
      .post<Question>(
        this.API,
        question
      );

  }

  addAnswer(questionId: String, answers: Answer[]) {

    return this.http.patch<Question>(this.API + '/' + questionId, answers);
  }
  handleError(error: any): Promise<any> {

    this.dialog.open(ErrorPopupComponent);
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
