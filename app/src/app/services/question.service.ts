import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { Question } from '../interfaces/Question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private http: HttpClient) { }
  fetchQuestions() {
    return this.http
      .get<{ [key: string]: Question }>(
        'https://quizzes-app-demo-default-rtdb.firebaseio.com/questions.json'
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
}
