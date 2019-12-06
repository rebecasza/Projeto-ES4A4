import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { NotaService } from '../../services/nota.service';
import { MateriaService } from '../../services/materia.service';

@Component({
  selector: 'app-nota',
  templateUrl: './nota.component.html',
  styleUrls: ['./nota.component.css']
})

export class NotaComponent implements OnInit {
  public materias;
  public materia;
  public valor: number;
  public peso: number;
  public usuario;
  public nota;
  public notas;
  public notasCheck: boolean;
  public media;

  constructor(
    public notaService: NotaService,
    public materiaService: MateriaService
  ) { }

  ngOnInit() {
    this.notasCheck = false;
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

  addNota(form: NgForm) {
    this.materia = form.value.materia;
    this.valor = form.value.nota;
    this.peso = form.value.peso;

    this.nota = {
      valor: this.valor,
      peso: this.peso
    };

    this.notaService.createNota(this.usuario, this.materia, this.nota);

    form.resetForm();
  }

  getNotasbyMateria(materiaId) {
    this.notaService.getAllNotas(this.usuario, materiaId)
    .then((notas) => {
      this.notas = notas;
      this.notasCheck = true;
      console.log(notas);
    });
  }

  getMedia(materiaId) {
    this.notaService.mediaNota(this.usuario, materiaId)
    .then((media) => {
      this.media = media;
      this.notasCheck = true;
      console.log(media);
    });
  }

  getNotasbyMateriaOk() {
    this.notas = '';
  }
}
