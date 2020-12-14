import { Component, OnInit } from '@angular/core';
import {RestService} from "../../rest.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-admin-discussion',
  templateUrl: './admin-discussion.component.html',
  styleUrls: ['./admin-discussion.component.css']
})
export class AdminDiscussionComponent implements OnInit {

  discussionData: any = '';
  showDiscussion:boolean = false;
  discussions: any = [];

  constructor(public rest : RestService, private route : ActivatedRoute, private router : Router) {
    console.log('Contact component - activated constructor');
    this.discussions = [];
    this.rest.getDiscussions().subscribe((data: {}) => {
      console.log('Contact component - messages loading');
      this.discussions = data;
      console.log(data);
    });
  }

  ngOnInit(): void {
  }

  showSelectedDiscussion(id){
    console.log("Selected Discussion: ", id);
    this.showDiscussion=true;
    this.discussionData = this.discussions[id-1];
    console.log('Selected discussion to display: ', this.discussionData['discussion']);

  }

  deleteDiscussion(id){
    console.log("Delete Discussion: ", id);
    this.rest.deleteDiscussion(id).subscribe((result)=>{
      this.router.navigate(['/main']);
    }, (err) =>{
      console.log(err);
    });
  }

}
