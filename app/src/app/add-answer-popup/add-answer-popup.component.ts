import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Answer } from '../models/Answer';

@Component({
  selector: 'app-add-answer-popup',
  templateUrl: './add-answer-popup.component.html',
  styleUrls: ['./add-answer-popup.component.css']
})
export class AddAnswerPopupComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<AddAnswerPopupComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Answer,) { }
  onNoClick(): void {
    this.dialogRef.close();
  }
  ngOnInit(): void {
  }

}
