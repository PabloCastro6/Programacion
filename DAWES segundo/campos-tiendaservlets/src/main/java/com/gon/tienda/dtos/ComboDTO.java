package com.gon.tienda.dtos;

public class ComboDTO {
	
	private Integer id;
	private String nombre;
	
	public ComboDTO(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	

	public ComboDTO() {
		super();
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	

}
