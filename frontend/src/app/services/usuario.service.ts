import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { AppComponent } from '../app.component';
import { Headers, RequestOptions } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../models/usuario';
import { Route, Router } from '@angular/router';

@Injectable()

export class UsuarioService {
  constructor(private http: HttpClient, public router: Router) {}

  getAllUsers() {
    return this.http.get(AppComponent.API_URL + '/all')
    .toPromise();
  }

  createUser(user: Usuario) {
    return this.http.post(AppComponent.API_URL + '/create', user)
    .toPromise();
  }

  getUserById(id: number) {
    return this.http.get(AppComponent.API_URL + '/usuario/' + id)
    .toPromise();
  }

  deleteUserById(id: number) {
    return this.http.delete(AppComponent.API_URL + '/usuario/' + id)
    .toPromise();
  }
}
