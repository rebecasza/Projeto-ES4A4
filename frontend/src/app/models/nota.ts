import { Materia } from './materia';

export class Nota {
  id: number;
  valor: number;
  peso: number;
  descricao: string;
  materia: Materia;

  constructor(id: number, nome: string, valor: number, peso: number, descricao: string, materia: Materia) {
    this.id = id;
    this.valor = valor;
    this.peso = peso;
    this.descricao = descricao;
    this.materia = materia;
  }
}
