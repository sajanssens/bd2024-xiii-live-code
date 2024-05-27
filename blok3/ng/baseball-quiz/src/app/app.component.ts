import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {MenubarComponent} from "./components/menubar/menubar.component";
import {MatSlideToggle} from "@angular/material/slide-toggle";
import {MatPaginator} from "@angular/material/paginator";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MenubarComponent, MatSlideToggle, MatPaginator],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'baseball-quiz';
}
