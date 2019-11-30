import { Component, OnInit } from '@angular/core';
import {Headers, Http} from '@angular/http';
import {Router} from '@angular/router';
import {LocalStorage} from '../common/local.storage';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private http: Http, private router: Router, private ls: LocalStorage) { }

  ngOnInit() {
  }

  login(value: any) {
    console.log(value);
    const headers: Headers = new Headers();
    headers.append('Content-Type', 'application/json');
    this.http.post('http://localhost:7071/user/login', value, {headers: headers}).subscribe((data) => {
      console.log(data.json().data);
      this.ls.setObject('loginUser', data.json().data);
      $('#loginLink').hide();
      $('#loginUser').text(data.json().data.name);
      $('#logoutLink').show();
      this.router.navigate(['/current']);
    });
  }

}
