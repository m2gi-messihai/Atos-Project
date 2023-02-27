import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddQuestionComponent } from './add-question/add-question.component';
import { AssignExamToStudentComponent } from './assign-exam-to-student/assign-exam-to-student.component';
import { AssignedExamsComponent } from './assigned-exams/assigned-exams.component';
import { ExamFormComponent } from './exam-form/exam-form.component';

import { ExamPageComponent } from './exam-page/exam-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { RegistrationComponent } from './registration/registration.component';
import { RoleFormComponent } from './role-form/role-form.component';
import { TakeExamComponent } from './take-exam/take-exam.component';
import { ViewQuestionsComponent } from './view-questions/view-questions.component';

const routes: Routes = [{ path: '', component: HomePageComponent },
{ path: 'questionBank', component: ViewQuestionsComponent },
{ path: 'roleForm', component: RoleFormComponent },
{ path: 'questionform', component: AddQuestionComponent },
{ path: 'registration', component: RegistrationComponent },
{ path: 'examForm', component: ExamFormComponent },
{ path: 'assignedExams', component: AssignedExamsComponent },
{ path: ":examId/assignExam", component: AssignExamToStudentComponent },
{ path: ":examId", component: ExamPageComponent },
{ path: "takeExam/:id", component: TakeExamComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
