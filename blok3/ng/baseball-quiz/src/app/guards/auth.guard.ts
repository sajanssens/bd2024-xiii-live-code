import {inject} from '@angular/core';
import {Router, RouterStateSnapshot} from '@angular/router';
import {UserService} from '../services/user.service';

export const authGuard = (state: RouterStateSnapshot) => {
  const router = inject(Router)
  const userService = inject(UserService)

  if (userService.isLoggedIn()) {
    return true;
  }

  // not logged in so redirect to login page with the return url
  router.navigate(['/login'], {queryParams: {returnUrl: state.url}});
  return false;
}
