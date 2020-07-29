import { Component, OnInit } from '@angular/core';
import {RestService} from "../../rest.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-admin-messages',
  templateUrl: './admin-messages.component.html',
  styleUrls: ['./admin-messages.component.css']
})
export class AdminMessagesComponent implements OnInit {

  messageData: any = '';
  showMessage:boolean = false;
  messages: any = [];

  constructor(public rest : RestService, private route : ActivatedRoute, private router : Router) {
    console.log('Contact component - activated constructor');
    this.messages = [];
    this.rest.getMessages().subscribe((data: {}) => {
      console.log('Contact component - messages loading');
      this.messages = data;
      console.log(data);
    });
  }

  ngOnInit() {
  }

  showSelectedMessage(id){
    console.log("Selected Message: ", id);
    this.showMessage=true;
    this.messageData = this.messages[id-1];
    console.log('Selected message to display: ', this.messageData['message']);

  }

  deleteMessage(id){
    console.log("Delete User: ", id);
    this.rest.deleteMessage(id).subscribe((result)=>{
      this.router.navigate(['/main']);
    }, (err) =>{
      console.log(err);
    });
  }

}
