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
    // define se a função é get, post ou delete
    // entre () define o caminho da função que foi declarado no backend
    return this.http.get<{ users }>(AppComponent.API_URL + 'usuario/all')
    // toPromise() espera a volta da fução
    .toPromise()
    // res é a volta do get, no caso, os users
    .then(res => {
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }

  createUser(user: Usuario) {
    return this.http.post(AppComponent.API_URL + '/usuario/create', user)
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
