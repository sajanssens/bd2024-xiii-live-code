import {Routes} from '@angular/router';
import {AdminComponent} from "./components/admin/admin.component";
import {HomeComponent} from "./components/home/home.component";
import {QuestionComponent} from "./components/question/question.component";

export const routes: Routes = [
  {path: '', component: HomeComponent},
  {
    path: 'admin', component: AdminComponent, // now, add router-outlet to AdminComponent's template
    children: [
      {path: ':subPath', component: QuestionComponent}
    ]
  },
  {path: 'questions/:subPath', component: QuestionComponent}

];
