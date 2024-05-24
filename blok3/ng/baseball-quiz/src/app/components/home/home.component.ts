import {Component} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {Question} from "../../domain/Question";


@Component({
  selector: 'bq-home',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  inputValue: String = "default value";

  questions: Question[] = [
    {id: 1, description: "Batter runs from ..."},
    {id: 2, description: "Batter runs from ..."},
    {id: 3, description: "Batter runs from ..."},
    {id: 4, description: "Batter runs from ..."},
  ];

  isHidden: boolean = true;

  resetInputValue(): void {
    this.inputValue = "";
  }

  getValue(): String {
    return "call naar backend..."
  }

  showToggle() {
    this.isHidden = !this.isHidden
  }

  showOrHideLabel(): String {
    return this.isHidden ? "Show" : "Hide"
  }

  myId() {
    return "niceId"
  }

  getAriaLabel() {
    return "question x"
  }
}
