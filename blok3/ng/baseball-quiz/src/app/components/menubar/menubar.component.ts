import {Component} from '@angular/core';
import {RouterLink, RouterLinkActive} from "@angular/router";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'bq-menubar',
  standalone: true,
  imports: [
    RouterLinkActive,
    RouterLink
  ],
  templateUrl: './menubar.component.html',
  styleUrl: './menubar.component.scss'
})
export class MenubarComponent {
  loggedInMessage = 'Not logged in.';

  constructor(private userService: UserService) {
    userService.loggedInMessage$.subscribe(m =>
      this.loggedInMessage = m
    )
  }

  isLoggedIn() {
    return this.userService.isLoggedIn();
  }

  logout() {
    return this.userService.logout();
  }
}
