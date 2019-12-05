import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { AppComponent } from '../app.component';
import { Headers, RequestOptions } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Route, Router } from '@angular/router';

@Injectable()

export class EstudoService {
  constructor(private http: HttpClient, public router: Router) {}

  getAllEstudos() {
    return this.http.get<{ estudos }>(AppComponent.API_URL + '/usuario/estudo/all')
    .toPromise()
    .then(res => {
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }

  createEstudo(user, materia, estudo) {
    return this.http.post(AppComponent.API_URL + '/usuario/' + user.id + '/materia/' + materia + '/estudo/', estudo)
    .toPromise()
    .then(res => {
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }

  editEstudo(user, estudo) {
    return this.http.get(AppComponent.API_URL + '/usuario/' + user + '/estudo/' + estudo.id)
    .toPromise()
    .then(res => {
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }

  deleteEstudo(user, estudo) {
    return this.http.delete(AppComponent.API_URL + '/usuario/' + user + '/estudo/' + estudo.id)
    .toPromise();
  }

}
