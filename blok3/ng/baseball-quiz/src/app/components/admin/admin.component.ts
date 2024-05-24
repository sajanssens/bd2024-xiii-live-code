import {Component} from '@angular/core';
import data from "../../data/questions.json";
import {QuestionsComponent} from "../questions/questions.component";

@Component({
  selector: 'bq-admin',
  standalone: true,
  imports: [
    QuestionsComponent
  ],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.scss'
})
export class AdminComponent {

  protected readonly questions = data;
}
