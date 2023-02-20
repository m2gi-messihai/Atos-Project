import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ExamDefinition } from '../models/ExamDefinition';

@Injectable({
  providedIn: 'root'
})
export class ExamDefinitionService {
  API = 'http://localhost:8080/examForm';

  constructor(private http: HttpClient) { }
  createExamDefinition(examDefinition: ExamDefinition) {
    return this.http
      .post<ExamDefinition>(
        this.API,
        examDefinition
      );
  }


}
