import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { MateriaService } from '../../services/materia.service';

@Component({
  selector: 'app-materia',
  templateUrl: './materia.component.html',
  styleUrls: ['./materia.component.css']
})

export class MateriaComponent implements OnInit {

  constructor(
    public router: Router,
    public materiaService: MateriaService
    ) { }

  public materia;
  public nome: string;
  public tipo: number;
  public desc: string;
  public usuario;
  public materias;

  ngOnInit() {
    this.usuario = {
      id: 1,
      nome: 'Admin',
      sobrenome: 'Master',
      senha: 'admin',
      email: 'admin@admin.com'
    };
    this.buscarMaterias();
  }

  criarMateria(form: NgForm) {
    this.nome = form.value.materia;
    if (form.value.tipoMedia === 'aritmetica') {
       this.tipo = 1;
     } else {
       if (form.value.tipoMedia === 'ponderada') {
         this.tipo = 2;
       }
     }

    this.desc = form.value.descricao;
    this.materia = {
      nome: this.nome,
      tipoMedia: this.tipo,
      descricao: this.desc
    };

    this.materiaService.createMateria(this.usuario, this.materia)
    .then(() => {
      this.buscarMaterias();
      form.resetForm();
    });
  }

  deleteMaterias(materiaId) {
    this.materiaService.deleteMateria(this.usuario, materiaId)
    .then(() => {
    this.buscarMaterias();
    });
  }


  buscarMaterias() {
    this.materiaService.getAllMaterias(this.usuario)
    .then((materias) =>
      this.materias = materias
    );
  }
}
