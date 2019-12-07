import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { AppComponent } from '../app.component';
import { Headers, RequestOptions } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Route, Router } from '@angular/router';

@Injectable()

export class UsuarioService {
  constructor(private http: HttpClient, public router: Router) {}

  getAllUsers() {
    return this.http.get<{ users }>(AppComponent.API_URL + '/usuario/all')
    .toPromise()
    .then(res => {
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }

  createUser(user) {
    return this.http.post(AppComponent.API_URL + '/usuario', user)
    .toPromise();
  }

  getUserById(id: number) {
    return this.http.get(AppComponent.API_URL + '/usuario/' + id)
    .toPromise();
  }

  getUserByEmail(email: string) {
    return this.http.get(AppComponent.API_URL + '/usuario/email/' + email)
    .toPromise()
    .then(res => {
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }

  deleteUserById(id: number) {
    return this.http.delete(AppComponent.API_URL + '/usuario/' + id)
    .toPromise();
  }
}
