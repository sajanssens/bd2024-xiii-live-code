import {Component} from '@angular/core';
import questions from "../../data/questions.json";
import {RouterLink} from "@angular/router";
import {Question} from "../../domain/Question";

@Component({
  selector: 'bq-questions',
  standalone: true,
  imports: [
    RouterLink
  ],
  templateUrl: './questions.component.html',
  styleUrl: './questions.component.scss'
})
export class QuestionsComponent {
  protected readonly questions: Question[] = questions;

}
