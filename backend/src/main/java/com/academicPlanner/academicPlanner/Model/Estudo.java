package com.academicPlanner.academicPlanner.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

@Entity
public class Estudo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Materia materia;
	
	@ManyToOne
	private Usuario usuario;
	
	private String dataInicio; 
	private String dataFim;
	
	
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
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

	
	
	public Estudo(Long id, Materia materia, Usuario usuario, String dataInicio, String dataFim) {
		super();
		this.id = id;
		this.materia = materia;
		this.usuario = usuario;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
	
	public Estudo() {
		super();
	}
	
	
}
