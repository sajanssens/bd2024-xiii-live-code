import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserService} from '../services/user.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  constructor(private userService: UserService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log("intercepting...")
    // add authorization header with jwt if available
    if (this.userService.isLoggedIn()) {
      console.log("isLoggedIn...")

      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${this.userService.loggedInUser()?.token}`
        }
      });
      console.log(request)
    }

    return next.handle(request);
  }
}
