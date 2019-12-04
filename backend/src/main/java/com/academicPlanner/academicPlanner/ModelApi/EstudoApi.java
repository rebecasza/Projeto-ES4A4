package com.academicPlanner.academicPlanner.ModelApi;

public class EstudoApi {
	
	private long id;
	private String dataInicio; 
	private String dataFim;
	
	
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
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
