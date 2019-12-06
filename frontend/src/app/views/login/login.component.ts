import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from '../../services/usuario.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    public router: Router,
    public usuarioService: UsuarioService
    ) { }

  
  public user;
  public email: string;
  public senha: string;
  loginTeste: boolean;
  erroNone: boolean;
  erroWrong: boolean;


  ngOnInit() {
    this.loginTeste = false;
    console.log(this.loginTeste);
    this.erroNone = false;
    this.erroWrong = false;
  }

  login(form: NgForm) {
    this.email = form.value.email;
    this.senha = form.value.senha;

    this.usuarioService.getUserByEmail(this.email)
    .then((user) => {
    this.user = user;

    if (this.user != null){
      if(this.user.senha == this.senha){
         this.loginTeste = true;
          this.router.navigate(['/app']);
           console.log("Login Efetuado!");
      }else{
        console.log("Erro!");
        this.erroWrong = true;
        this.erroNone = false;
      }
    }else{
      console.log("Erro! Usuario não existe!")
      this.erroNone = true;
      this.erroWrong = false;
    }
    });


}
    goRegistro() {
    }

}
