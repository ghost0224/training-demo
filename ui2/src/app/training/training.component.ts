import {AfterViewInit, Component, OnInit} from '@angular/core';
import {Http} from '@angular/http';
import {Router} from '@angular/router';
import {LocalStorage} from '../common/local.storage';

@Component({
  selector: 'app-training',
  templateUrl: './training.component.html',
  styleUrls: ['./training.component.css']
})
export class TrainingComponent implements OnInit, AfterViewInit {

  constructor(private http: Http, private router: Router, private ls: LocalStorage) { }

  currentList = new Array();

  ngOnInit() {
  }

  ngAfterViewInit(): void {
    const that = this;
    console.log(this.ls.getObject('loginUser'));
    const headers: Headers = new Headers();
    headers.append('Content-Type', 'application/json');
    this.http.get('http://localhost:7071/training/training/findByUserId/' + (this.ls.getObject('loginUser').id)).subscribe(function(data) {
      for (let i = 0; i < data.json().data.length; i++) {
        that.currentList = data.json().data;
      }
      console.log(that.currentList);
    }, function (error) {
      console.log(error);
    });
  }

}
