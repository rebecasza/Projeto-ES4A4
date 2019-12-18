import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { AppComponent } from '../app.component';
import { Headers, RequestOptions } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Route, Router } from '@angular/router';

@Injectable()

export class TopicoService {
  constructor(private http: HttpClient, public router: Router) {}

  
  getAllTopicos(user, materiaId) {
    return this.http.get<{ topicos }>(AppComponent.API_URL + '/usuario/' + user.id + '/materia/' + materiaId + '/topico/all')
    .toPromise()
    .then(res => {
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }

  createTopico(user, materiaId, topico) {
    return this.http.post(AppComponent.API_URL + '/usuario/' + user.id + '/materia/' + materiaId + '/topico/', topico)
    .toPromise()
    .then(res => {
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }

  editTopico(user, materiaId, topico) {
    return this.http.get(AppComponent.API_URL + '/usuario/' + user.id + 'materia' + materiaId + '/topico/' + topico.id)
    .toPromise()
    .then(res => {
      return res;
    })
    .catch(error => {
      console.log(error);
    });
  }

  deleteTopico(user, materiaId, topico) {
    return this.http.delete(AppComponent.API_URL + '/usuario/' + user.id + '/materia/' + materiaId + '/topico/' + topico.id)
    .toPromise();
  }


}