import {Component, Input, OnInit} from '@angular/core';
import {User} from "../model/user";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {UserService} from "../user.service";
import {AuthService} from "../security/auth.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userList:{}=[];
  @Input() registrationData:any = {username:'', password:'',firstName: '', lastName: '', email: ''};


  constructor(private http:HttpClient, private userService:UserService, private router:Router, private auth:AuthService) { }

  ngOnInit() {
    console.log("Register Component - CurrentUser: ", this.auth.currentUser);
    if (this.auth.currentUserValue) {
      alert("Already Registered");
      this.router.navigate(['/main']);
    }
    console.log("Getting all usernames");
    this.userService.getAllUsernames().subscribe((data: {}) => {
      console.log('Register component - usernames loading');
      this.userList = data;})
    console.log("Usernames retrieved: ", this.userList);
  }

  addUser(registrationData){
    this.userService.addUser(registrationData).subscribe(res => {
      console.log("Added user without errors: ", res);
      this.router.navigate(['/main']);
    });
  }

  toggled($event: Event) {
    console.log($event);
  }
}
