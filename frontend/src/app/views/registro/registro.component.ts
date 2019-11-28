import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UsuarioService } from '../../services/usuario.service';
import { Usuario } from '../../models/usuario';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})

export class RegistroComponent implements OnInit {

  constructor(
    private userService: UsuarioService
  ) { }

  public nome: string;
  public sobrenome: string;
  public email: string;
  public senha: string;
  public user: Usuario;

  ngOnInit() {
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
  }

}
