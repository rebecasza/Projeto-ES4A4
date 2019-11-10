package com.academicPlanner.academicPlanner.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Nota {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private float valor;
	private int peso;
	private String descricao;
	
	/*
	private Materia materia;
	*/
}
