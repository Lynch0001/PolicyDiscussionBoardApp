import {Component, Input, OnInit} from '@angular/core';
import {RestService} from "../../rest.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../security/auth.service";
import {UserService} from "../../user.service";
import {Observable} from "rxjs";
import {tap} from "rxjs/operators";

@Component({
  selector: 'app-admin-users-edit',
  templateUrl: './admin-users-edit.component.html',
  styleUrls: ['./admin-users-edit.component.css']
})
export class AdminUsersEditComponent implements OnInit {

  @Input() userData: any = {id:'', username:'', firstName:'', lastName:'', email:'', activatedDate:'', lastLogin:'', roles:''}

  constructor(public userService : UserService, private route : ActivatedRoute, private router : Router, private auth:AuthService) { }

  ngOnInit(): void {
    console.log("AdminUserEdit Component Init");
    this.userService.getUser(this.route.snapshot.params['id']).subscribe((data: {}) => {
      console.log('Admin-User-Edit component - data loading');
      this.userData = data;
      console.log(data);
    });
  }

  deleteUser(){
    console.log("Delete User Method");
    this.userService.deleteUser(this.route.snapshot.params['id']).subscribe((result)=>{
      this.router.navigate(['/admin-dashboard']);
    }, (err) =>{
      console.log(err);
    });
  }

  updateUser(){
    this.userService.updateUser(this.userData).subscribe(res => {
      console.log("Updated user without errors: ", res);
      this.router.navigate(['/admin-messages']);
    });
  }

}
