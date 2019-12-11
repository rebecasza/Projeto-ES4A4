package com.academicPlanner.academicPlanner.ModelApi;

import javax.validation.constraints.NotBlank;

public class EstudoApi {
	
	private Long id;
	
	@NotBlank(message = "Data é obrigatório")
	private String date;


	
	
	public String getData() {
		return date;
	}
	public void setData(String date) {
		this.date = date;
	}
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
