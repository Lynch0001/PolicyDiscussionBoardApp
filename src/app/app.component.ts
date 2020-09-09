import { Component } from '@angular/core';
import {RestService} from './rest.service';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {AuthService} from './security/auth.service';
import {User} from './model/user';
import {UserService} from './user.service';
import {first} from 'rxjs/operators';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  currentUser: User;

  constructor(private router: Router, private authService: AuthService) {
    console.log('App Component');
    this.authService.currentUser.subscribe(x => this.currentUser = x);
    console.log('App Component - Current User is: ', this.currentUser);
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
