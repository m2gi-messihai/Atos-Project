import { Component, OnInit, Input } from '@angular/core';
import { QuestionService } from '../services/question.service';

@Component({
  selector: 'app-answer-form',
  templateUrl: './answer-form.component.html',
  styleUrls: ['./answer-form.component.css']
})
export class AnswerFormComponent implements OnInit {
  @Input() questionId: String = "";

  constructor(public questionService: QuestionService) { }

  ngOnInit(): void {
  }
  onSubmit() {
    // this.questionService.addAnswer
    console.log(this.questionId);
    return false;
  }

}
