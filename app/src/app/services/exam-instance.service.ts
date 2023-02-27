import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ExamInstance } from '../models/ExamInstance';
import { GeneratedLink } from '../models/GeneratedLink';

@Injectable({
  providedIn: 'root'
})
export class ExamInstanceService {
  API = 'http://localhost:8082/exams';

  constructor(private http: HttpClient) { }
  assignExam(examDefinition: ExamInstance) {
    return this.http
      .post<ExamInstance>(
        this.API + "/assignExam",
        examDefinition
      );
  }
}
