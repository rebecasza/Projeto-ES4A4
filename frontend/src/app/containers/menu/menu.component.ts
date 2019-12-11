import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})

export class MenuComponent implements OnInit {

  constructor(public router: Router) { }

  ngOnInit() {
  }

  logout() {
    sessionStorage.clear();
    localStorage.clear();
    this.router.navigateByUrl('/login');
    location.reload();
  }

}
