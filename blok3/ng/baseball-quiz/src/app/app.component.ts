import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {MenubarComponent} from "./components/menubar/menubar.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MenubarComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'baseball-quiz';
}
