import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {Injectable} from '@angular/core';
import { AuthService} from './auth.service';

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {

  constructor(private router: Router, private authService: AuthService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    console.log('AuthGuard activated');
    const currentUser = this.authService.currentUserValue;
     console.log('AuthGuard user loggedIn status: ', currentUser);

      if (currentUser == null) {
        // not logged in so redirect to login page with the return url
        console.log('AuthGuard not validating login - return to Login page');
        this.router.navigate(['/login'], { queryParams: { returnUrl: state.url } });
        return false;
    }
    // logged in so return true
    return true;
  }
}
