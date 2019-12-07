package com.academicPlanner.academicPlanner.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Estudo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Materia materia;
	
	@ManyToOne
	private Usuario usuario;
	
	private String data;
	
	
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
	public Estudo(Long id, Materia materia, Usuario usuario, String data) {
		super();
		this.id = id;
		this.materia = materia;
		this.usuario = usuario;
		this.data = data;
	}
	
	public Estudo() {
		super();
	}
	
	
}
