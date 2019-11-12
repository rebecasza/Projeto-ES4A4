import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-materia',
  templateUrl: './materia.component.html',
  styleUrls: ['./materia.component.css']
})
export class MateriaComponent implements OnInit {

  constructor(public router: Router) { }
  public materia: string;
  public tipo: string;
  public desc: string;

  ngOnInit() {
  }

  criarMateria(form: NgForm) {
    this.materia = form.value.materia;
    this.tipo = form.value.tipoMedia;
    this.desc = form.value.descricao;

    console.log(this.materia);
    console.log(this.tipo);
    console.log(this.desc);
  }
}
