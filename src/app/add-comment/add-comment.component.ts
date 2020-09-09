import {Component, Input, OnInit} from '@angular/core';
import {RestService} from '../rest.service';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from '../security/auth.service';

@Component({
  selector: 'app-add-comment',
  templateUrl: './add-comment.component.html',
  styleUrls: ['./add-comment.component.css']
})
export class AddCommentComponent implements OnInit{

  @Input() discussionData: any = {discussTitle:''};
  @Input() commentData:any = { id:'', commentContent:'', commentTimeStamp:'', contributor:''};

  constructor(public rest: RestService, private route: ActivatedRoute, private router: Router, private auth:AuthService) { }

  ngOnInit() {}

  updateDiscussion() {
    let contributor:String = this.auth.currentUserValue.firstName + " " + this.auth.currentUserValue.lastName;
    this.commentData.contributor = contributor;
    this.commentData.commentTimeStamp = new Date();
    this.discussionData['comments'].push(this.commentData);
    this.rest.updateDiscussion(this.discussionData).subscribe(res => {
      console.log('Added comment without errors: ', res);
      this.router.navigate(['/main']);
    }, (err) => {
      console.log('Error Adding Comment: ', err);
      this.router.navigate(['/main']);
    });
  }
}
