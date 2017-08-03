package com.qindel.webapp.modelo.entities;

import java.io.Serializable;

public class Sede_jjoo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2L;

	private Integer anyo;
	private Tipo_jjoo tipo_jjoo;
	private Ciudad sede;
	
	public Sede_jjoo(Integer anyo, Tipo_jjoo tipo_jjoo, Ciudad sede) {
		
		this.anyo = anyo;
		this.tipo_jjoo = tipo_jjoo;
		this.sede = sede;
	}

	public Integer getAnyo() {
		return anyo;
	}

	public void setAnyo(Integer anyo) {
		this.anyo = anyo;
	}

	public Tipo_jjoo getTipo_jjoo() {
		return tipo_jjoo;
	}

	public void setTipo_jjoo(Tipo_jjoo tipo_jjoo) {
		this.tipo_jjoo = tipo_jjoo;
	}
	
	public Ciudad getSede() {
		return sede;
	}
	
	public void setSede(Ciudad sede) {
		this.sede = sede;
	}
	
}
