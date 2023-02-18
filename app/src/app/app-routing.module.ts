import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddQuestionComponent } from './add-question/add-question.component';
import { RegistrationComponent } from './registration/registration.component';
import { ViewQuestionsComponent } from './view-questions/view-questions.component';

const routes: Routes = [{ path: '', component: ViewQuestionsComponent }, { path: 'questionform', component: AddQuestionComponent }, { path: 'registration', component: RegistrationComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
