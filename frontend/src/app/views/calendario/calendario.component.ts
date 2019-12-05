import { Component, OnInit } from '@angular/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import { EstudoService } from '../../services/estudo.service';
import { MateriaService } from '../../services/materia.service';

@Component({
  selector: 'app-calendario',
  templateUrl: './calendario.component.html',
  styleUrls: ['./calendario.component.css']
})

export class CalendarioComponent implements OnInit{
  calendarPlugins = [dayGridPlugin];
  public events;
  public eventsFinal;
  public usuario;
  public materia;

  constructor(
    private estudoService: EstudoService,
    private materiaService: MateriaService
  ) {}

  ngOnInit() {
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
      console.log(this.events);
      this.estudosForEvents(this.events);
    });
  }

  estudosForEvents(estudos) {
    console.log(estudos);
    for (let estudo of estudos) {
      this.materiaService.getMateriaId(this.usuario, estudo.materia)
      .then((materia) => {
        this.materia = materia;
        this.eventsFinal = [
          { title: this.materia.nome, date: estudo.data }
        ];
        console.log(this.eventsFinal);
      });
    }
  }
}

