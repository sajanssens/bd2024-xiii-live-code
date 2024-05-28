import {Component, OnInit} from '@angular/core';
import {RouterLink} from "@angular/router";
import {Question} from "../../domain/Question";
import {QuestionService} from "../../services/question.service";
import {Observable} from "rxjs";
import {AsyncPipe, DatePipe, LowerCasePipe, UpperCasePipe} from "@angular/common";
import {MatPaginator, MatPaginatorIntl, PageEvent} from "@angular/material/paginator";
import {MyPaginatorConfig} from "../../my.paginator.config";
import {SearchComponent} from "../search/search.component";

@Component({
  selector: 'bq-questions',
  standalone: true,
  imports: [
    RouterLink,
    AsyncPipe,
    UpperCasePipe,
    LowerCasePipe,
    DatePipe,
    MatPaginator,
    SearchComponent
  ],
  templateUrl: './questions.component.html',
  styleUrl: './questions.component.scss',
  providers: [{provide: MatPaginatorIntl, useClass: MyPaginatorConfig}],
})
export class QuestionsComponent implements OnInit {
  questions: Question[] = [];
  questions$!: Observable<Question[]>;

  // for paging:
  totalItems = 100;
  pageSize = 5;
  currentPage = 0;
  pageSizeOptions = [1, 5, 10, 25]

  constructor(private questionService: QuestionService) {
  }

  ngOnInit(): void {
    this.questions$ = this.questionService.questionsUpdated$;
    this.getAllQuestions()
  }

  getAllQuestions() {
    this.questionService.findAll();
    this.questions$?.subscribe(r => {
        this.totalItems = r.length

        let start = this.currentPage * this.pageSize;
        let end = start + this.pageSize;
        this.questions = r.slice(start, end);
      }
    )
  }

  remove(id: number) {
    this.questionService.remove(id);
  }

  pageChanged(event: PageEvent) {
    this.currentPage = event.pageIndex;
    this.pageSize = event.pageSize;
    this.getAllQuestions()
  }

  handleSearch(searchTerm: string) {
    this.questionService.search(searchTerm)
  }
}

