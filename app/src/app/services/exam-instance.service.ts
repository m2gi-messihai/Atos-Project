import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { ExamInstance } from '../models/ExamInstance';
import { ExamQuestion } from '../models/ExamQuestion';
import { GeneratedLink } from '../models/GeneratedLink';
import { GetAssignedExamNameDto } from '../models/GetAssignedExam';

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
  getAssignedExams() {
    return this.http
      .get<{ [key: string]: GetAssignedExamNameDto }>(
        this.API + "/assignedExams"
      )
      .pipe(
        map((res) => {
          const assignedExams = [];
          for (const key in res) {
            if (res.hasOwnProperty(key)) {
              assignedExams.push({ ...res[key], id: key });
            }
          }
          return assignedExams;
        })
      );
  }
  startExam(id: string) {
    return this.http
      .patch<ExamInstance>(
        this.API + "/startExam/" + id, new Date()
      );

  }

}