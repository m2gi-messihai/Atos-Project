import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

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
import { AddAnswerPopupComponent } from './add-answer-popup/add-answer-popup.component'

@NgModule({
  declarations: [
    AppComponent,
    AddQuestionComponent,
    ViewQuestionsComponent,
    AddAnswerPopupComponent
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
    MatInputModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
