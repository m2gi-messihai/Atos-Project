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
import { AnswerFormComponent } from './answer-form/answer-form.component'
import { MatSelectModule } from '@angular/material/select'
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatPaginatorModule } from '@angular/material/paginator'
import { MatDatepickerModule } from '@angular/material/datepicker'
import { MatNativeDateModule } from '@angular/material/core';
import { MatAutocompleteModule } from '@angular/material/autocomplete'

import { ErrorPopupComponent } from './error-popup/error-popup.component';
import { RegistrationComponent } from './registration/registration.component';
import { ExamFormComponent } from './exam-form/exam-form.component';
import { HomePageComponent } from './home-page/home-page.component';
import { NavigationBarComponent } from './navigation-bar/navigation-bar.component';
import { MatMenuModule } from '@angular/material/menu';
import { ExamPageComponent } from './exam-page/exam-page.component'
import { RoleFormComponent } from './role-form/role-form.component';
import { AddQuestionsPopupComponent } from './add-questions-popup/add-questions-popup.component';
import { AssignExamToStudentComponent } from './assign-exam-to-student/assign-exam-to-student.component';
import { TakeExamComponent } from './take-exam/take-exam.component';
import { AssignedExamsComponent } from './assigned-exams/assigned-exams.component';
import { ExamInitialPageComponent } from './exam-initial-page/exam-initial-page.component';



@NgModule({
  declarations: [
    AppComponent,
    AddQuestionComponent,
    ViewQuestionsComponent,
    AnswerFormComponent,
    ErrorPopupComponent,
    RegistrationComponent,
    ExamFormComponent,
    HomePageComponent,
    NavigationBarComponent,
    ExamPageComponent,
    RoleFormComponent,
    AddQuestionsPopupComponent,
    AssignExamToStudentComponent,
    TakeExamComponent,
    AssignedExamsComponent,
    ExamInitialPageComponent,

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
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    MatPaginatorModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatMenuModule,
    MatAutocompleteModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
