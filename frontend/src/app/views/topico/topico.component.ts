import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { TopicoService } from '../../services/topico.service';
import { MateriaService } from '../../services/materia.service';

@Component({
  selector: 'app-topico',
  templateUrl: './topico.component.html',
  styleUrls: ['./topico.component.css']
})
export class TopicoComponent implements OnInit {

  public materias;
  public materia;
  public nome: String;
  public descricao: String;
  public usuario;
  public topico;
  public topicos;
  public topicosCheck: boolean;
  public user;

  constructor(
    private topicoService: TopicoService,
    private materiaService: MateriaService
  ) { }

 
  ngOnInit() {
    this.topicosCheck = false;
    this.user = window.localStorage.getItem('user');
    this.usuario = JSON.parse(this.user);
    this.materiaService.getAllMaterias(this.usuario)
    .then((materias) => {
      this.materias = materias;
    });
  }

  addTopico(form: NgForm) {
    this.materia = form.value.materia;
    this.nome = form.value.nome;
    this.descricao = form.value.descricao;

    this.topico = {
      nome: this.nome,
      descricao: this.descricao
    };

    this.topicoService.createTopico(this.usuario, this.materia, this.topico);

    form.resetForm();
  }

  getTopicosbyMateria(materiaId) {
    this.topicoService.getAllTopicos(this.usuario, materiaId)
    .then((topicos) => {
      this.topicos = topicos;
      this.topicosCheck = true;
      console.log(topicos);
    });
  }

  getTopicosbyMateriaOk() {
    this.topicos = '';
  }


}
