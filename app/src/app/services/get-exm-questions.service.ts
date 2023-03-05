import { Injectable } from '@angular/core';
import { ExamInstanceService } from './exam-instance.service';

@Injectable({
  providedIn: 'root'
})
export class GetExmQuestionsService {

  constructor(private examInstanceService: ExamInstanceService) { }
  getExamQuestions(examId: string, questionId: string) {
    return this.examInstanceService.getQuestionForExam(examId, questionId);
  }
  getAssignedExamById(examId: string) {
    return this.examInstanceService.getAssignedExamById(examId);
  }
}
