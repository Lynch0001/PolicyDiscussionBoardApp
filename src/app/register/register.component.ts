import {Component, Input, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../user.service';
import {AuthService} from '../security/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userUsernameList:string[] = [];
  userEmailList:string[] = [];
  @Input() registrationData:any = {username:'', password:'',firstName: '', lastName: '', email: ''};


  constructor(private http:HttpClient, private userService:UserService, private router:Router, private route: ActivatedRoute, private auth:AuthService) { }

  ngOnInit() {
    console.log('Register Component - CurrentUser: ', this.auth.currentUser);
    if (this.auth.currentUserValue) {
      alert('Already Registered');
      this.router.navigate(['/main']);
    }
    console.log('Getting all usernames');
    this.userService.getAllUsernames().subscribe((data: string[]) => {
      console.log('Register component - usernames loading');
      this.userUsernameList = data;
      console.log('Usernames retrieved: ', this.userUsernameList);
    })
    // console.log('Getting all emails');
    this.userService.getAllUserEmails().subscribe((data: string[]) => {
      console.log('Register component - emails loading');
      this.userEmailList = data;
      // console.log('User Emails retrieved: ', this.userEmailList);
    })
  }

  addUser(registrationData){
    // check if username or email are in registered users list
    if(this.userUsernameList.includes(this.registrationData.username.toLowerCase())){
      alert('username already in use!');
      return;
    }
    if(this.userEmailList.includes(this.registrationData.email.toLowerCase())){
      alert('email is already registered!');
      return;
    }
    // convert username and email to lowercase
    this.registrationData.username = this.registrationData.username.toLowerCase();
    this.registrationData.email = this.registrationData.email.toLowerCase();
    this.auth.registeredUser = true;
    // submit registration data
    this.userService.addUser(registrationData).subscribe(res => {
      console.log('Added user without errors: ', res);},
        error => {console.log('User Registration error while processing: ' + error);},
      () => {console.log('User Registration Complete without errors');}
      );
    this.router.navigate(['login']);
  }

  toggled($event: Event) {
    console.log($event);
  }
}
