import { Component, OnInit } from '@angular/core';
import {RestService} from "../../rest.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-admin-comment',
  templateUrl: './admin-comment.component.html',
  styleUrls: ['./admin-comment.component.css']
})
export class AdminCommentComponent implements OnInit {

  commentData: any = '';
  showComment:boolean = false;
  comments: any = [];

  constructor(public rest : RestService, private route : ActivatedRoute, private router : Router) {
    console.log('Admin-Comment component - activated constructor');
    this.comments = [];
    this.rest.getAllComments().subscribe((data: {}) => {
      console.log('Admin component - comments loading');
      this.comments = data;
      console.log(data);
    });
  }

  ngOnInit() {
  }

  showSelectedComment(id){
    console.log("Selected comment: ", id);
    this.showComment=true;
    this.commentData = this.comments[id-1];
    console.log('Selected comment to display: ', this.commentData['comment']);

  }

  deleteComment(id){
    console.log("Delete comment: ", id);
    this.rest.deleteComment(id).subscribe((result)=>{
      this.router.navigate(['/main']);
    }, (err) =>{
      console.log(err);
    });
  }
}
