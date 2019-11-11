export class Usuario {
  id: number;
  nome: string;
  sobrenome: string;
  email: string;
  senha: string;

  constructor(id: number, nome: string, sobrenome: string, email: string, senha: string) {
    this.id = id;
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.email = email;
    this.senha = senha;
  }
}
