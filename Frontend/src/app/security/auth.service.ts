import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {BehaviorSubject, Observable} from 'rxjs';
import {User} from '../model/user';
import {RestService} from '../rest.service';


@Injectable({ providedIn: 'root' })
export class AuthService {
  endpoint = 'http://localhost:8080/api/';
  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;
  public registeredUser: boolean = false;

  constructor(private http: HttpClient, private rest: RestService, private router:Router) {
    // console.log('AuthService Constructor');
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): User {
    // console.log('Getting AuthService currentUserValue: ', this.currentUserSubject.value);
    return this.currentUserSubject.value;
  }


  login(username: string, password: string) {
    let credentials = {username: username, password: password};
    // console.log('Login credentials: ', credentials);
    this.rest.getUser(credentials).subscribe((user:{}) => {
      let tempUser:User = <User>user;
      tempUser.authdata = window.btoa(username + ':' + password);
      // console.log('User credential data: ', tempUser.authdata);
      localStorage.setItem('currentUser', JSON.stringify(tempUser));
      this.currentUserSubject.next(tempUser);
      // console.log('***** currentUserSubjectValue: ', this.currentUserSubject.value);
      // console.log('User in local storage: ', localStorage.getItem('currentUser'));
      //return this.currentUser;
      console.log('***** currentUser: ', this.currentUser);
      //return this.currentUser;
    });
    // console.log('***** currentUser: ', this.currentUser);
    return this.currentUser;
  }




  logout(){
    console.log('Logout activated');
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
    this.registeredUser = false;
    this.router.navigate(['/logout'])
  }

}
