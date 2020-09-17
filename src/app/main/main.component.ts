import {Component, Input, OnInit} from '@angular/core';
import {RestService} from '../rest.service';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from '../security/auth.service';


@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  showTags:any = [];
  discussion:any;
  discussions: any = [];
  name:string = '';

  constructor(public rest : RestService, private route : ActivatedRoute, private router : Router, private auth:AuthService) {
    console.log('Main component - activated constructor');
    this.discussions = [];
    this.showTags =[];
    this.rest.getDiscussionHeaders().subscribe((data: {}) => {
      console.log('Main component - data loading');
      this.discussions = data;
      this.showTags = this.discussions.tags;
      console.log(data);
    });
  }
  ngOnInit() {

  }

  checkLoginAndRoute(id:number){
    console.log('Main - User Check: ' + this.auth.currentUserValue);
    if(this.auth.currentUserValue == null){
      alert('You must register and log in to view discussion content.');
      this.router.navigate(['home']);
    }
    else{
      console.log('Id value: ' + id);
      this.router.navigate(['review/', id]);
    }
  }

  getByContributor(name: string){
    console.log('Main - get by contributor called.');
    if(this.auth.currentUserValue == null){
      alert('You must register and log in to view discussion content.');
      this.router.navigate(['home']);
    }
    else{
      console.log('Contributor value: ' + name);
      this.rest.getDiscussionsByContributor(name).subscribe((data: {}) => {
        console.log('Main component - data loading');
        this.discussions = data;
        this.showTags = this.discussions.tags;
        console.log(data);
      });
    }
  }
}
