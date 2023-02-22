import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { ExamDefinition } from '../models/ExamDefinition';

@Injectable({
  providedIn: 'root'
})
export class ExamDefinitionService {
  API = 'http://localhost:8082/exams';

  constructor(private http: HttpClient) { }
  createExamDefinition(examDefinition: ExamDefinition) {
    return this.http
      .post<ExamDefinition>(
        this.API + "/examForm",
        examDefinition
      );
  }
  getExamDefinition() {
    return this.http
      .get<{ [key: string]: ExamDefinition }>(
        this.API
      )
      .pipe(
        map((res) => {
          const exams = [];
          for (const key in res) {
            if (res.hasOwnProperty(key)) {
              exams.push({ ...res[key], id: key });
            }
          }
          return exams;
        })
      );
  }


}
