import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Answer } from '../models/Answer';

@Injectable({
  providedIn: 'root'
})
export class AnswerService {

  // constructor(private http: HttpClient) { }
  // addAnswer(answer: Answer) {
  //   this.http.post<{ body: string }>(
  //     'https://quizzes-app-demo-default-rtdb.firebaseio.com/questions/:{question}/choice.json', answer
  //   ).subscribe((res) => {
  //     console.log(res);

  //   });
  // }
}
