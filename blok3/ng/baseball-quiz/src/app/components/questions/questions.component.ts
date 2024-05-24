import {Component, OnInit} from '@angular/core';
import {RouterLink} from "@angular/router";
import {Question} from "../../domain/Question";
import {QuestionService} from "../../services/question.service";
import {Observable} from "rxjs";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'bq-questions',
  standalone: true,
  imports: [
    RouterLink,
    AsyncPipe
  ],
  templateUrl: './questions.component.html',
  styleUrl: './questions.component.scss'
})
export class QuestionsComponent implements OnInit {
  $questions: Observable<Question[]> | undefined;

  constructor(private questionService: QuestionService) {

  }

  ngOnInit(): void {
    this.getAllQuestions()
  }

  getAllQuestions() {
    this.$questions = this.questionService.findAll();
  }

}
