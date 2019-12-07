package com.academicPlanner.academicPlanner.ModelApi;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MateriaApi {
	
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	private String descricao;
	
	private float media;
	
	@NotBlank(message = "Tipo de média é obrigatório!")
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
	
}
