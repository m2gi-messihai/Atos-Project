import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Answer } from '../models/Answer';
import { QuestionService } from '../services/question.service';

@Component({
  selector: 'app-add-answer-popup',
  templateUrl: './add-answer-popup.component.html',
  styleUrls: ['./add-answer-popup.component.css']
})
export class AddAnswerPopupComponent implements OnInit {

  constructor(public questionService: QuestionService, public dialogRef: MatDialogRef<AddAnswerPopupComponent>) { }
  onNoClick(): void {
    this.dialogRef.close();
  }
  ngOnInit(): void {
  }

  addAnswer() {
  }
  exitPopup() {
    this.dialogRef.close();
  }

}
