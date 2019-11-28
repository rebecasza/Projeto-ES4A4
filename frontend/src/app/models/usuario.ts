export class Usuario {
  nome: string;
  sobrenome: string;
  email: string;
  senha: string;

  constructor(nome: string, sobrenome: string, email: string, senha: string) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.email = email;
    this.senha = senha;
  }
}
