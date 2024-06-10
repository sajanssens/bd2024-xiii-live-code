import { Component } from '@angular/core';
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {User} from "../../domain/User";
import {FormsModule} from "@angular/forms";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'bq-login',
  templateUrl: './login.component.html',
  imports: [
    FormsModule,
    AsyncPipe
  ],
  standalone: true
})
export class LoginComponent {
  user = {} as User;
  message$ = this.service.message$;

  constructor(private service: UserService, private router: Router) {
  }

  login(): void {
    console.log(this.user)
    this.service.login(this.user);
    this.user = {} as User;
  }
}
