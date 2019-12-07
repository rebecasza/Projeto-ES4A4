import { Component, OnInit, Input } from '@angular/core';
import { Router, NavigationStart } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {

  constructor(private router: Router) {
}

  static API_URL = 'http://localhost:8080';
  title = 'Academic Planner';
  showHead: boolean;


  @Input() loginTeste: boolean;

  ngOnInit() {
    this.showHead = false;
    this.router.events.forEach((event) => {
      if (event instanceof NavigationStart) {
        if (event.url === '/' || event.url === '/registro') {
          this.showHead = false;
        } else {
          this.showHead = true;
        }
      }
    });
  }
}
