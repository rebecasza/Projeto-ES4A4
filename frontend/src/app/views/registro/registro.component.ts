import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UsuarioService } from '../../services/usuario.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})

export class RegistroComponent implements OnInit {

  registro: boolean;

  constructor(
    private userService: UsuarioService
  ) { }

  public nome: string;
  public sobrenome: string;
  public email: string;
  public senha: string;
  public user;

  ngOnInit() {
    this.registro = false;
  }


  criarUsuario(form: NgForm) {
    this.nome = form.value.nome;
    this.sobrenome = form.value.sobrenome;
    this.email = form.value.email;
    this.senha = form.value.senha;

    this.user = {
      nome: this.nome,
      sobrenome: this.sobrenome,
      email: this.email,
      senha: this.senha
    };

    this.userService.createUser(this.user);
    this.registro = true;
  }

}
