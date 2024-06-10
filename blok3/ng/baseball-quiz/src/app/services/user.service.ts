import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';
import {serverUrl} from '../../environments/environment';
import {Router} from "@angular/router";
import {User} from "../domain/User";

@Injectable({providedIn: 'root'}) // ApplicationScoped
export class UserService {

  public static readonly emptyUser = {} as User;

  public loggedInMessage$ = new Subject<string>();
  public message$ = new Subject<string>();

  private uri = serverUrl + '/users';

  constructor(private http: HttpClient, private router: Router) {
  }

  login(u: User): void {
    this.http.post<User>(`${this.uri}/login`, u, {observe: 'response'} /* = to receive the full httpresponse instead of only the body */)
      .subscribe({
        next: (response) => {
          // get the body from the response:
          const loggedInUser = response.body ?? UserService.emptyUser;

          this.loggedInMessage$.next(`Logged in as ${loggedInUser.username}`);
          this.message$.next(`Gebruiker ${loggedInUser.username} is ingelogd.`);
          localStorage.setItem('loggedInUser', JSON.stringify(loggedInUser));

          // ... or get the Authorization header from the response:
          // const token = response.headers.get('Authorization')?.substr(7);
          // localStorage.setItem('token', JSON.stringify(token));
        },
        error: (errorResponse) => {
          this.message$.next(`Inloggen is mislukt.  Reden: ${errorResponse.statusText}.`);
        }
      });
  }

  isLoggedIn() {
    return localStorage.getItem('loggedInUser') !== null;
  }

  loggedInUser(): User | null {
    // @ts-ignore
    return JSON.parse(localStorage.getItem('loggedInUser')) as User;
  }

  logout(): void {
    localStorage.removeItem('loggedInUser')
    this.loggedInMessage$.next('Not logged in')
    this.router.navigate(['/login']);
  }


}

