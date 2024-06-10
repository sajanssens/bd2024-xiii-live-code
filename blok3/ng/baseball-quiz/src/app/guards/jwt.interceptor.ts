import {inject, Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpHandlerFn, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserService} from '../services/user.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  constructor(private userService: UserService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // add authorization header with jwt if available
    if (this.userService.isLoggedIn()) {
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${this.userService.loggedInUser()?.token}`
        }
      });
    }

    return next.handle(request);
  }
}

export function jwtInterceptorFn(req: HttpRequest<any>, next: HttpHandlerFn): Observable<HttpEvent<any>> {
  const userService = inject(UserService)

  if (userService.isLoggedIn()) {
    req = req.clone({
      setHeaders: {
        Authorization: `Bearer ${userService.loggedInUser()?.token}`
      }
    });
  }
  return next(req);
}
