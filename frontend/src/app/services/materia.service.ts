import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { AppComponent } from '../app.component';
import { Headers, RequestOptions } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Route, Router } from '@angular/router';

@Injectable()

export class MateriaService {
  constructor(private http: HttpClient, public router: Router) {}

  getAllMaterias(user) {
    return this.http.get<{ materias }>(AppComponent.API_URL + '/usuario/' + user.id + '/materia/all')
    .toPromise()
    .then(res => {
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }

  getMateriaId(user, materia) {
    return this.http.get<{ materias }>(AppComponent.API_URL + '/usuario/' + user.id  + '/materia/' + materia.id)
    .toPromise()
    .then(res => {
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }

  createMateria(user, materia) {
    return this.http.post(AppComponent.API_URL + '/usuario/' + user.id + '/materia/', materia)
    .toPromise()
    .then(res => {
      console.log(res);
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }

  editMateria(user, materiaId) {
    return this.http.get(AppComponent.API_URL + '/usuario/' + user.id + '/materia/' + materiaId)
    .toPromise()
    .then(res => {
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }

  deleteMateria(user, materiaId) {
    return this.http.delete(AppComponent.API_URL + '/usuario/' + user.id + '/materia/' + materiaId)
    .toPromise();
  }

}
