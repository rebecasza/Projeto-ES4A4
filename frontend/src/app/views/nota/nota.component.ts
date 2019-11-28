import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Materia } from 'src/app/models/materia';

@Component({
  selector: 'app-nota',
  templateUrl: './nota.component.html',
  styleUrls: ['./nota.component.css']
})

export class NotaComponent implements OnInit {
  public materia: Materia[];
  public nota: number;
  public peso: number;

  constructor() { }

  ngOnInit() {
    this.materia = [
      { id: 1, nome: 'História', descricao: 'Teste1'},
      { id: 2, nome: 'Matemática', descricao: 'Teste2'},
    ];
  }

  addNota(form: NgForm) {
    this.materia = form.value.materia;
    this.nota = form.value.nota;
    this.peso = form.value.peso;

    console.log(this.materia);
    console.log(this.nota);
    console.log(this.peso);

    form.resetForm();
  }
}
