import {Routes} from '@angular/router';
import {AdminComponent} from "./components/admin/admin.component";
import {HomeComponent} from "./components/home/home.component";
import {QuestionComponent} from "./components/question/question.component";
import {ContactFormComponent} from "./components/contact-form/contact-form.component";
import {LoginComponent} from "./components/login/login.component";
import {authGuard} from "./guards/auth.guard";

export const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {
    path: 'admin', component: AdminComponent, canActivate: [authGuard], // now, add router-outlet to AdminComponent's template
    children: [
      {path: ':subPath', component: QuestionComponent}
    ]
  },
  {path: 'questions/:subPath', component: QuestionComponent},
  {path: 'contact', component: ContactFormComponent},
  {path: 'login', component: LoginComponent},
];
