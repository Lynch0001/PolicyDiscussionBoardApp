import {Component, Input, OnInit} from '@angular/core';
import {RestService} from '../rest.service';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from '../security/auth.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  tempTag: String = '';
  tempTags:any = [];
  @Input() discussionData:any = { id:'', discussTitle:'', discussSubTitle: '', tags: '', discussContent: '',
    discussTimestamp:'', contributor:''
  };

  constructor(public rest: RestService, private route: ActivatedRoute, private router: Router, private auth:AuthService) { }

  ngOnInit() {
  }


  addDiscussion() {
    if(this.tempTags == null || this.tempTags == ''){
      alert('Please enter a subject tag for this post!');
      return;
    }
    this.discussionData.tags = this.tempTags;
    let contributor:String = this.auth.currentUserValue.firstName + " " + this.auth.currentUserValue.lastName;
    console.log('adding contributor to discussion', contributor);
    this.discussionData.contributor = contributor;
    this.discussionData.discussTimestamp = new Date();
    console.log(this.discussionData);
    this.rest.addDiscussion(this.discussionData).subscribe(res => {
      console.log('Added comment without errors: ', res);
      this.router.navigate(['/main']);
    }, (err) => {
      console.log('Error Adding Comment: ', err);
      this.router.navigate(['/main']);
    });
  }

  addTag(tag: String){
    if(tag == null || tag == ''){
      alert('Please enter a subject tag for this post!');
      return;
    }
    this.tempTags.push(tag);
    this.tempTag='';
  }

}
