import {Component, Input, OnInit} from '@angular/core';
import {RestService} from '../rest.service';
import { FormsModule } from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  @Input() messageData:any = { id:'', name:'', email:'', message: '', messageTimestamp:''};

  constructor(public rest : RestService, private route : ActivatedRoute, private router : Router) {
    console.log('Contact component - activated constructor');
  }

  ngOnInit() {
  }

  addMessage() {

    this.messageData.messageTimestamp = new Date();
    console.log(this.messageData);

    this.rest.addMessage(this.messageData).subscribe(res => {
      console.log('Added message without errors: ', res);
      this.router.navigate(['/main']);
    }, (err) => {
      console.log('Error Adding Comment: ', err);
      this.router.navigate(['/main']);
    });
  }

}
