import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Question} from "../../domain/Question";
import questions from "../../data/questions.json";
import {FormsModule, NgForm} from "@angular/forms";

@Component({
  selector: 'bq-question',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './question.component.html',
  styleUrl: './question.component.scss'
})
export class QuestionComponent implements OnInit {


  protected readonly questions: Question[] = questions;
  question: Question = {} as Question;

  constructor(private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    let id = (idParam !== null) ? +idParam : -1;
    this.question = this.questions.find(q => q.id === id) ?? {} as Question;
  }


  save(questionForm: NgForm) {
    this.question = {} as Question
    this.router.navigate(['admin'])
  }

  cancel() {
    this.router.navigate(['admin'])
  }
}
