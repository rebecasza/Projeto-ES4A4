import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  constructor() { }
  public nome: string;
  public sobrenome: string;
  public email: string;
  public senha: string;

  ngOnInit() {
  }

  
  criarUsuario(form: NgForm) {
    this.nome = form.value.nome;
    this.sobrenome = form.value.sobrenome;
    this.email = form.value.email;
    this.senha = form.value.senha;

    console.log(this.nome);
    console.log(this.sobrenome);
    console.log(this.email);
    console.log(this.senha);
  }

}
