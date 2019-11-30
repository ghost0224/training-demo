import {AfterViewInit, Component, OnInit} from '@angular/core';
import {Headers, Http} from '@angular/http';
import {Router} from '@angular/router';
import {LocalStorage} from '../common/local.storage';
import * as $ from 'jquery';

@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.css']
})
export class PayComponent implements OnInit {

  constructor(private http: Http, private router: Router, private ls: LocalStorage) { }
  selectTraining;
  loginUser;
  payment = new Payment();

  ngOnInit() {
    this.selectTraining = this.ls.getObject('selectTraining');
    this.loginUser = this.ls.getObject('loginUser');
    this.payment.userId = this.loginUser.id;
    this.payment.trainingId = this.selectTraining.id;
    this.payment.trainingName = this.selectTraining.title;
    this.payment.amount = this.selectTraining.fees;
  }

  pay() {
    if (confirm('To pay?') === true) {
      this.payment.remarks = $('#remarks').val();
      console.log(this.payment);
      const headers: Headers = new Headers();
      headers.append('Content-Type', 'application/json');
      this.http.post('http://localhost:7071/payment/payment/save', this.payment, {headers: headers}).subscribe((data) => {
        if (data.json().status === true) {
          this.http.post('http://localhost:7071/user/book/' + this.payment.userId + '/' + this.payment.trainingId,{headers: headers}).subscribe((d) => {
            if (data.json().status === true) {
              this.router.navigate(['/current']);
            }
          });
        }
      });
    }
  }
}

class Payment {
  userId;
  trainingId;
  trainingName;
  amount;
  remarks;
}
