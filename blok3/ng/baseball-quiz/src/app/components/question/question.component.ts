import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Question} from "../../domain/Question";
import {FormsModule, NgForm} from "@angular/forms";
import {QuestionService} from "../../services/question.service";

@Component({
  selector: 'bq-question',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './question.component.html',
  styleUrl: './question.component.scss'
})
export class QuestionComponent implements OnInit {

  @Input() editMode = true;
  question: Question = {} as Question;
  mode: string = "Wijzig";

  constructor(private route: ActivatedRoute,
              private router: Router,
              private service: QuestionService) {
  }

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    if (idParam === 'add') {
      this.editMode = false;
      this.mode = "Toevoegen"
    } else {
      this.loadQuestion(idParam);
    }
  }

  private loadQuestion(idParam: string | null) {
    let id = (idParam !== null) ? +idParam : -1;
    this.service.find(id).subscribe(result => this.question = result);
  }

  save(questionForm: NgForm) {
    if (this.editMode) {
      this.service.update(questionForm.value)
    } else {
      this.service.add(questionForm.value)
    }
    this.back();
  }

  cancel() {
    this.back();
  }

  private back() {
    this.router.navigate(['admin'])
  }
}
