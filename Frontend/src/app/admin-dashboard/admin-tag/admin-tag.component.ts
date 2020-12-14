import { Component, OnInit } from '@angular/core';
import {RestService} from "../../rest.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-admin-tag',
  templateUrl: './admin-tag.component.html',
  styleUrls: ['./admin-tag.component.css']
})
export class AdminTagComponent implements OnInit {

  tag:any = '';
  tags: any = [];
  hideTag:boolean = true;

  constructor(public rest : RestService, private route : ActivatedRoute, private router : Router) {
    console.log('Admin-Tag component - activated constructor');
    this.tags = [];
    this.rest.getAllTags().subscribe((data: {}) => {
      console.log('Admin component - tags loading');
      this.tags = data;
      console.log(this.tags[0]);
    });
  }

  ngOnInit() {
  }

  deleteTag(id){
    console.log("Delete tag: ", id);
    this.rest.deleteTag(id).subscribe((result)=>{
      this.router.navigate(['/main']);
    }, (err) =>{
      console.log(err);
    });
  }

  editTag(tag){
    console.log("Update tag: ", tag.tag);
    this.rest.editTag(tag).subscribe((result)=>{
      this.router.navigate(['/admin']);
    }, (err) =>{
      console.log(err);
    });
  }

  showTag(){
    this.hideTag = false;
  }
}
