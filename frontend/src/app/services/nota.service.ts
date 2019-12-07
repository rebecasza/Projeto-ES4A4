import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { AppComponent } from '../app.component';
import { Headers, RequestOptions } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Route, Router } from '@angular/router';

@Injectable()

export class NotaService {
  constructor(private http: HttpClient, public router: Router) {}

  getAllNotas(user, materiaId) {
    return this.http.get<{ notas }>(AppComponent.API_URL + '/usuario/' + user.id + '/materia/' + materiaId + '/nota/all')
    .toPromise()
    .then(res => {
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }

  createNota(user, materiaId, nota) {
    return this.http.post(AppComponent.API_URL + '/usuario/' + user.id + '/materia/' + materiaId + '/nota/', nota)
    .toPromise()
    .then(res => {
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }

  editNota(user, materiaId, nota) {
    return this.http.get(AppComponent.API_URL + '/usuario/' + user.id + 'materia' + materiaId + '/nota/' + nota.id)
    .toPromise()
    .then(res => {
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }

  deleteNota(user, materiaId, nota) {
    return this.http.delete(AppComponent.API_URL + '/usuario/' + user.id + '/materia/' + materiaId + '/nota/' + nota.id)
    .toPromise();
  }

  mediaNota(user, materia) {
    return this.http.get(AppComponent.API_URL + '/usuario/' + user.id + '/materia/' + materia + '/nota/media/')
    .toPromise()
    .then(res => {
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }


}
