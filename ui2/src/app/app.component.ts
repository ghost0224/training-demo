import {Component, OnInit} from '@angular/core';
import {Http} from '@angular/http';
import {Router} from '@angular/router';
import {LocalStorage} from './common/local.storage';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(private http: Http, private router: Router, private ls: LocalStorage) { }
  title = 'app';
  ngOnInit(): void {
    $('#logoutLink').hide();
  }

  logout() {
    this.ls.setObject('loginUser', null);
    this.router.navigate(['/login']);
  }

}
