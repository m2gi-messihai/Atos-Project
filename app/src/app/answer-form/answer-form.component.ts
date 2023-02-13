import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Answer } from '../models/Answer';
import { Question } from '../models/Question';
import { QuestionService } from '../services/question.service';

@Component({
  selector: 'app-answer-form',
  templateUrl: './answer-form.component.html',
  styleUrls: ['./answer-form.component.css']
})
export class AnswerFormComponent implements OnInit {
  @Input() question: Question | null = null;

  answerForm: FormGroup;


  constructor(public questionService: QuestionService, private fb: FormBuilder) {
    this.answerForm = this.fb.group({
      name: ['', [Validators.required]],
      description: ['', [Validators.required]],
    }
    )
  }
  ngOnInit(): void {

  }
  onSubmit(answer: Answer) {

    if (this.question) {
      const questionId: String = this.question.key;
      let answers: Answer[] = [];
      if (this.question.answers) {
        answers = this.question.answers;
      }

      answers.push(answer);

      this.questionService.addAnswer(questionId, answers);

    }
    else {
      console.log("question is null")
    }
  }

}


