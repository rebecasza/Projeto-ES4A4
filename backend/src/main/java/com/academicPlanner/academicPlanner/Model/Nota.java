package com.academicPlanner.academicPlanner.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.academicPlanner.academicPlanner.Repository.MateriaRepository;
import com.academicPlanner.academicPlanner.Repository.NotaRepository;
import com.academicPlanner.academicPlanner.Service.ResourceNotFoundException;

@Entity
@Table(name = "nota")
public class Nota {
	
	private NotaRepository repository;
	private MateriaRepository repositoryMateria;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private float valor;
	
	private int peso;
	
	private String descricao;
	
	@ManyToOne
	private Materia materia;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public double media(Long id) {
		
		Materia mat = repositoryMateria.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Materia não encontrado"));
		
		List<Nota> notas = (List<Nota>) repository.findByMateria(mat);
		double media = 0;
		float total = 0;
		int qtd = 0;
		if (mat.getTipoMedia() == 1) {
			for(Nota nota: notas) {
				total += nota.getValor();
				qtd += 1;
			}
			media = (total/qtd);
			return media;
		}else if(mat.getTipoMedia() == 2){
			for(Nota nota: notas) {
				total += (nota.getValor()*nota.getPeso());
				qtd += 1;
			}
			media = (total/qtd);
			return media;
		}else {
			return 0;
		}
	
		
	}
}
