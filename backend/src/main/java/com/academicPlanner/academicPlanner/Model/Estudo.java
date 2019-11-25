package com.academicPlanner.academicPlanner.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CascadeType;

@Entity
public class Estudo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Materia materia;
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
	
	
	public Estudo(Materia materia, String dataInicio, String dataFim) {
		super();
		this.materia = materia;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
	
	public Estudo() {
		super();
	}
	
	
}
