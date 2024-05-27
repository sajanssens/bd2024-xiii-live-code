import {Component, OnInit} from '@angular/core';
import {RouterLink} from "@angular/router";
import {Question} from "../../domain/Question";
import {QuestionService} from "../../services/question.service";
import {Observable} from "rxjs";
import {AsyncPipe, DatePipe, LowerCasePipe, UpperCasePipe} from "@angular/common";
import {MatPaginator, MatPaginatorIntl, PageEvent} from "@angular/material/paginator";
import {MyPaginatorConfig} from "../../my.paginator.config";

@Component({
  selector: 'bq-questions',
  standalone: true,
  imports: [
    RouterLink,
    AsyncPipe,
    UpperCasePipe,
    LowerCasePipe,
    DatePipe,
    MatPaginator
  ],
  templateUrl: './questions.component.html',
  styleUrl: './questions.component.scss',
  providers: [{provide: MatPaginatorIntl, useClass: MyPaginatorConfig}],
})
export class QuestionsComponent implements OnInit {
  questions$: Observable<Question[]> | undefined;
  questions: Question[] = [];

  totalItems = 100;
  pageSize = 5;
  currentPage = 0;
  pageSizeOptions = [1, 5, 10, 25]

  constructor(private questionService: QuestionService) {

  }

  ngOnInit(): void {
    this.getAllQuestions()
  }

  getAllQuestions() {
    this.questions$ = this.questionService.findAll();
    this.questions$.subscribe(r => {
        this.totalItems = r.length
        this.questions = r.slice(this.currentPage, this.currentPage + this.pageSize);
      }
    )
  }

  pageChanged(event: PageEvent) {
    this.currentPage = event.pageIndex;
    this.pageSize = event.pageSize;
    this.getAllQuestions()
  }

  remove(id: number) {
    this.questionService.remove(id).subscribe(() => this.getAllQuestions())
  }
}

