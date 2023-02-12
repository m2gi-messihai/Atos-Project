import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddQuestionComponent } from './add-question/add-question.component';
import { ViewQuestionsComponent } from './view-questions/view-questions.component';
import { HttpClientModule } from '@angular/common/http';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon'
import { MatButtonModule } from '@angular/material/button'
import { MatRadioModule } from '@angular/material/radio'
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field'
import { MatInputModule } from '@angular/material/input'
<<<<<<< HEAD
import { AddAnswerPopupComponent } from './add-answer-popup/add-answer-popup.component'
import { MatSelectModule } from '@angular/material/select'
=======
import { MatCheckboxModule } from '@angular/material/checkbox';
import { AnswerFormComponent } from './answer-form/answer-form.component'

>>>>>>> add-answer-feature

@NgModule({
  declarations: [
    AppComponent,
    AddQuestionComponent,
    ViewQuestionsComponent,
    AnswerFormComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NoopAnimationsModule,
    MatCardModule,
    MatIconModule,
    MatButtonModule,
    MatRadioModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
<<<<<<< HEAD
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule
=======
    MatCheckboxModule
>>>>>>> add-answer-feature

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
