import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  constructor(
    public router: Router
    ) { }

  loginTeste: boolean;

  ngOnInit() {
    this.loginTeste = false;
    console.log(this.loginTeste);
  }

  login() {
    this.loginTeste = true;
    console.log(this.loginTeste);
  }

    goRegistro() {
    }

}
