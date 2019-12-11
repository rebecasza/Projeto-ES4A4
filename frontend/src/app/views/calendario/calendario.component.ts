import { Component, OnInit } from '@angular/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import { EstudoService } from '../../services/estudo.service';
import { MateriaService } from '../../services/materia.service';

@Component({
  selector: 'app-calendario',
  templateUrl: './calendario.component.html',
  styleUrls: ['./calendario.component.css']
})

export class CalendarioComponent implements OnInit {
  calendarPlugins = [dayGridPlugin];
  public user;
  public events;
  public eventsFinal: any[] = [];
  public usuario;
  public materia;
  public calendar;

  constructor(
    private estudoService: EstudoService,
    private materiaService: MateriaService
  ) {}

  ngOnInit() {
    this.calendar = false;
    this.user = window.localStorage.getItem('user');
    this.usuario = JSON.parse(this.user);
    this.estudoService.getAllEstudos(this.usuario)
    .then((estudos) => {
      this.events = estudos;
      const objectLength = Object.keys(this.events).length;
      if (objectLength === 0) {
        this.calendar = true;
      } else {
        this.estudosForEvents(this.events);
      }
    });
  }

  estudosForEvents(estudos) {
    const objectLength = Object.keys(estudos).length;
    for (const estudo of estudos) {
      let index = 0;
      this.materiaService.getMateriaId(this.usuario, estudo.materia)
      .then((materia) => {
        this.materia = materia;
        this.eventsFinal[index] = { title: this.materia.nome, date: estudo.data };
        index++;
        if (index === objectLength) {
          this.calendar = true;
        }
      });
    }
  }
}

