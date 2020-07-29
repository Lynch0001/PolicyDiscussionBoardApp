import { Component, OnInit } from '@angular/core';
import {RestService} from "../rest.service";
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  showTags:any = [];
  discussions: any = [];

  constructor(public rest : RestService, private route : ActivatedRoute, private router : Router) {
    console.log('Main component - activated constructor');
    this.discussions = [];
    this.showTags =[];
    this.rest.getDiscussions().subscribe((data: {}) => {
      console.log('Main component - data loading');
      this.discussions = data;
      this.showTags = this.discussions.tags;
      console.log(data);
    });
  }
  ngOnInit() {

  }

}
