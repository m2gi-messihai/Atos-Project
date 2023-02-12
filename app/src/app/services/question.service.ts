import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { Answer } from '../models/Answer';
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

  deleteQuestion(key: String) {
    console.log(key);
    return this.http.delete(this.API + "/" + key).subscribe();

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
  // addAnswer(answer: Answer) {
  //   return this.http.patch<[key: string]>(
  //     'http://localhost:8080/questions/${id}', answer
  //   ).subscribe((res) => {
  //     console.log(res)
  //   })
  // }
}
