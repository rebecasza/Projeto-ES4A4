package com.academicPlanner.academicPlanner.Model;

import javax.persistence.*;


@Entity
@Table(name = "materia")
public class Materia {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	
	
	@ManyToOne
	private Usuario usuario;
	
	//private List<Nota> notas;
	
	private float media;
	
	
	private int tipoMedia;
	// tipo 1- m�dia aritm�tica
	// tipo 2- m�dia ponderada
	
	
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
	
	
	/*public List<Nota> getNotas() {
		return notas;
	}
			
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
*/
	public void pegaNotas() {
		// colocar uma query pro banco com notas do mesmo ID
	}
	
	
	public Materia(String nome, String descricao, Usuario usuario, float media, int tipoMedia) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.usuario = usuario;
		this.media = media;
		this.tipoMedia = tipoMedia;
	}
	
	public Materia() {
		super();
	}
	
	
	
	
	
}