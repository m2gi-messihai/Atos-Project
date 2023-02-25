import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { PageEvent } from '@angular/material/paginator';
import { Question } from '../models/Question';
import { QuestionService } from '../services/question.service';

@Component({
  selector: 'app-add-questions-popup',
  templateUrl: './add-questions-popup.component.html',
  styleUrls: ['./add-questions-popup.component.css']
})
export class AddQuestionsPopupComponent implements OnInit {
  questions: Question[] | null = null;
  questionIds: string[] | null = new Array();
  totalQuestionsCount: number = 0;
  pageSize: number[] = [3, 6, 9]
  currentPageSize: number = 3;
  pageNumber: number = 0;
  checkBoxState: boolean = false;

  constructor(@Inject(MAT_DIALOG_DATA) public data: string[], private questionService: QuestionService, public dialogRef: MatDialogRef<AddQuestionsPopupComponent>,) { }

  ngOnInit(): void {
    this.fetchQuestions(this.pageNumber, this.currentPageSize);
  }
  addToExam(key: string, event: any) {
    if (this.questionIds) {
      this.checkBoxState = event.checked;

      if (this.checkBoxState) {
        this.questionIds.push(key);
      }
      else {
        this.questionIds = this.questionIds.filter(questionId => questionId !== key);
      }
    }

  }
  showState() {

  }
  close() {
    this.dialogRef.close({ data: this.questionIds });
  }
  onPageChange(event: PageEvent) {
    this.fetchQuestions(event.pageIndex, event.pageSize)

  }
  fetchQuestions(pageNumber: number, pageSize: number) {
    this.questionService.fetchPaginatedQuestions(pageNumber, pageSize).subscribe(data => {
      this.questions = data.questions
      this.totalQuestionsCount = data.totalQuestions;
      this.currentPageSize = data.pageSize;
      this.pageNumber = data.pageNumber;
    })
  }

}
