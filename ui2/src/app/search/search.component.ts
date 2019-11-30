import { Component, OnInit } from '@angular/core';
import {Headers, Http} from '@angular/http';
import {Router} from '@angular/router';
import {LocalStorage} from '../common/local.storage';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searchList = new Array();

  constructor(private http: Http, private router: Router, private ls: LocalStorage) { }

  ngOnInit() {
  }

  search(value: any) {
    console.log(value);
    const headers: Headers = new Headers();
    headers.append('Content-Type', 'application/json');
    this.http.post('http://localhost:7071/training/training/search/' + (this.ls.getObject('loginUser').id), value, {headers: headers}).subscribe((data) => {
      this.searchList = data.json().data;
    });
  }

  enroll(id: any) {
    if (confirm('Are you sure to enroll this training?') === true) {
      this.http.get('http://localhost:7071/training/training/findById/' + id).subscribe((data) => {
        if (data.json().status) {
          this.ls.setObject('selectTraining', data.json().data);
          this.router.navigate(['/pay']);
        } else {
          alert('find error!');
        }
      });
    }
  }

}
