import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Question} from "../../domain/Question";
import {FormsModule, NgForm} from "@angular/forms";
import {QuestionService} from "../../services/question.service";

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

  question: Question = {} as Question;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private service: QuestionService) {
  }

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    let id = (idParam !== null) ? +idParam : -1;
    this.service.find(id).subscribe(result => this.question = result);
  }


  save(questionForm: NgForm) {
    this.question = {} as Question
    this.router.navigate(['admin'])
  }

  cancel() {
    this.router.navigate(['admin'])
  }
}
