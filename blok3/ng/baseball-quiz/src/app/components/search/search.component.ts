import {Component, EventEmitter, Input, Output} from '@angular/core';
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'bq-search',
  standalone: true,
  templateUrl: './search.component.html',
  imports: [
    FormsModule
  ],
  styleUrls: ['./search.component.scss']
})
export class SearchComponent {

  @Input() placeholder = "search terms..."
  @Output() search = new EventEmitter<string>()

  input: string = '';

  go() {
    this.search.emit(this.input)
  }

  clearIfEmpty() {
    if (this.input === '') {
      this.search.emit(this.input)
    }
  }
}
