import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MateriaService } from '../../services/materia.service';
import { EstudoService } from '../../services/estudo.service';

@Component({
  selector: 'app-planejamento',
  templateUrl: './planejamento.component.html',
  styleUrls: ['./planejamento.component.css']
})
export class PlanejamentoComponent implements OnInit {

  public usuario;
  public materias;
  public materia;
  public data;
  public estudo;
  public estudos;

  constructor(
    private materiaService: MateriaService,
    private estudoService: EstudoService
  ) { }

  ngOnInit() {
    this.getPlanejameto();
    this.usuario = {
      id: 4,
      nome: 'Admin',
      sobrenome: 'Master',
      senha: 'admin',
      email: 'admin@admin.com'
    };
    this.materiaService.getAllMaterias()
    .then((materias) => {
      this.materias = materias;
    });
  }

  addPlanejamento(form: NgForm) {
    this.materia = form.value.materia;
    this.data = form.value.data;

    this.estudo = {
      title: this.materia,
      data: this.data
    };

    this.estudoService.createEstudo(this.usuario, this.materia, this.estudo);

    form.resetForm();
  }

  getPlanejameto() {
    this.estudoService.getAllEstudos()
    .then((estudos) => {
      this.estudos = estudos;
      console.log(estudos);
    });
  }
}
