package com.qindel.webapp.modelo.entities;

import java.io.Serializable;

public class Tipo_jjoo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2L;
	
	private Integer id_tipo_jjoo;
	private String descripcion_tipo;
	
	public Tipo_jjoo(Integer id_tipo_jjoo, String descripcion_tipo) {
		this.id_tipo_jjoo = id_tipo_jjoo;
		this.descripcion_tipo = descripcion_tipo;
	}

	public Integer getId_tipo_jjoo() {
		return id_tipo_jjoo;
	}

	public void setId_tipo_jjoo(Integer id_tipo_jjoo) {
		this.id_tipo_jjoo = id_tipo_jjoo;
	}

	public String getDescripcion_tipo() {
		return descripcion_tipo;
	}

	public void setDescripcion_tipo(String descripcion_tipo) {
		this.descripcion_tipo = descripcion_tipo;
	}	
	
}
