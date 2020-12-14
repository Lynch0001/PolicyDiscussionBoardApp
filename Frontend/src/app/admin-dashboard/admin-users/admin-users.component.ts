import { Component, OnInit } from '@angular/core';
import {RestService} from "../../rest.service";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../user.service";

@Component({
  selector: 'app-admin-users',
  templateUrl: './admin-users.component.html',
  styleUrls: ['./admin-users.component.css']
})
export class AdminUsersComponent implements OnInit {

  users: any = [];

  constructor(public usersService : UserService, private route : ActivatedRoute, private router : Router) {
    console.log('Admin Users component - activated constructor');
    this.users = [];
    this.usersService.getUsers().subscribe((data: {}) => {
      console.log('Admin Users component - users loading');
      this.users = data;
      console.log(data);
    });
  }

  ngOnInit() {
  }

}
