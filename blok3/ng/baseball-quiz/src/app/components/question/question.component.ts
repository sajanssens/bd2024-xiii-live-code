import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Question} from "../../domain/Question";
import {FormsModule, NgForm, NgModel} from "@angular/forms";
import {QuestionService} from "../../services/question.service";

@Component({
  selector: 'bq-question',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './question.component.html',
  styleUrl: './question.component.scss'
})
export class QuestionComponent implements OnInit {

  editMode = true;
  question: Question = {} as Question;
  modeLabel: string = "Wijzig";

  constructor(private route: ActivatedRoute,
              private router: Router,
              private service: QuestionService) {
  }

  ngOnInit(): void {
    const subPath = this.route.snapshot.paramMap.get('subPath');
    if (subPath === 'add') {
      this.editMode = false;
      this.modeLabel = "Toevoegen"
    } else {
      this.loadQuestion(subPath);
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

  asterisk(model: NgModel) {
    return model.errors?.['required'] ? "*" : "";
  }
}
