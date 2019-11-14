package com.academicPlanner.academicPlanner.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Materia {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String descricao;
	
	
	@ManyToOne
	private Usuario usuario;
	
	private List<Nota> notas;
	
	private float media;
	private int tipoMedia;
	// tipo 1- média aritmética
	// tipo 2- média ponderada
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public float getMedia() {
		return media;
	}
	public void setMedia(float media) {
		this.media = media;
	}
	public int getTipoMedia() {
		return tipoMedia;
	}
	public void setTipoMedia(int tipoMedia) {
		this.tipoMedia = tipoMedia;
	}
	
	
	public List<Nota> getNotas() {
		return notas;
	}
			
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public void pegaNotas() {
		// colocar uma query pro banco com notas do mesmo ID
	}
	
	public void calculaMedia() {
		if(this.tipoMedia == 1) {
			// Calcular Média aritmetica de acordo com o array notas
		}
		else if (this.tipoMedia == 2) {
			// Calcular Média ponderada de acordo com o array notas
		}
	}
	
	
	
}