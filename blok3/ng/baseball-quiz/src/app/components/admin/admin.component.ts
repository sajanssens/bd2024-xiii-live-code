import {Component} from '@angular/core';
import data from "../../data/questions.json";
import {QuestionsComponent} from "../questions/questions.component";
import {RouterOutlet} from "@angular/router";

@Component({
  selector: 'bq-admin',
  standalone: true,
  imports: [
    QuestionsComponent,
    RouterOutlet
  ],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.scss'
})
export class AdminComponent {

  protected readonly questions = data;
}
