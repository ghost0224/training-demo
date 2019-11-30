import {AfterViewInit, Component, OnInit} from '@angular/core';
import {Http} from '@angular/http';
import {Router} from '@angular/router';
import {LocalStorage} from '../common/local.storage';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  constructor(private http: Http, private router: Router, private ls: LocalStorage) { }

  userPayment = new Array();

  ngOnInit() {
    const that = this;
    const headers: Headers = new Headers();
    headers.append('Content-Type', 'application/json');
    this.http.get('http://localhost:7071/payment/payment/findByUserId/' + (this.ls.getObject('loginUser').id)).subscribe(function(data) {
      for (let i = 0; i < data.json().data.length; i++) {
        that.userPayment = data.json().data;
      }
      console.log(that.userPayment);
    }, function (error) {
      console.log(error);
    });
  }

}
