import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { ExamInstance } from '../models/ExamInstance';
import { ExamQuestion } from '../models/ExamQuestion';
import { GeneratedLink } from '../models/GeneratedLink';

@Injectable({
  providedIn: 'root'
})
export class ExamInstanceService {
  API = 'http://localhost:8082/exams';

  constructor(private http: HttpClient) { }
  assignExam(examInstance: ExamInstance) {
    return this.http
      .post<ExamInstance>(
        this.API + "/assignExam",
        examInstance
      );
  }
  takeExam(examInstanceId: string, examQuestion: ExamQuestion[]) {
    return this.http
      .patch<ExamInstance>(
        this.API + "/" + examInstanceId + "/takeExam",
        examQuestion
      );

  }
  getAssignedExams() {
    return this.http
      .get<{ [key: string]: ExamInstance }>(
        this.API + "/assignedExams"
      )
      .pipe(
        map((res) => {
          const examInstances = [];
          for (const key in res) {
            if (res.hasOwnProperty(key)) {
              examInstances.push({ ...res[key], id: key });
            }
          }
          return examInstances;
        })
      );
  }

}
