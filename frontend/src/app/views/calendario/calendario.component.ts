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
    this.usuario = {
      id: 4,
      nome: 'Admin',
      sobrenome: 'Master',
      senha: 'admin',
      email: 'admin@admin.com'
    };
    this.estudoService.getAllEstudos()
    .then((estudos) => {
      this.events = estudos;
      this.estudosForEvents(this.events);
      console.log(this.eventsFinal);
    });
  }

  estudosForEvents(estudos) {
    for (const estudo of estudos) {
      var index = 0;
      this.materiaService.getMateriaId(this.usuario, estudo.materia)
      .then((materia) => {
        this.materia = materia;
        this.eventsFinal[index] = { title: this.materia.nome, date: estudo.data };
        this.calendar = true;
        index++;
      });
    }
  }
}

