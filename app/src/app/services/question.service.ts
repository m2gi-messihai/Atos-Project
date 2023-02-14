import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { Client } from '../clients/client';
import { Answer } from '../models/Answer';
import { GetAllQuestionsRsponseDto } from '../models/GetAllQuestionsResponseDto';
import { Question } from '../models/Question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  API = 'http://localhost:8080/questions';
  constructor(private http: HttpClient) { }
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
    return this.http.delete(this.API + "/" + id);

  }
  createQuestion(question: Question) {
    this.http
      .post<{ name: string }>(
        this.API,
        question
      )
      .subscribe((res) => {
        console.log(res);
      });
  }

  addAnswer(questionId: String, answers: Answer[]) {

    return this.http.patch<Question>(this.API + '/' + questionId, answers).subscribe((res) => {
      console.log(res);

    })
  }

}
