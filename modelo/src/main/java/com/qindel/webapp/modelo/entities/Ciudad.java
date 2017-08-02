package com.qindel.webapp.modelo.entities;

import java.io.Serializable;

public class Ciudad implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2L;
	private int id_ciudad;
	private String nombre_ciudad;
	private Pais pais;
	private int valor;
	
	public Ciudad(int id_ciudad, String nombre_ciudad, Pais pais, int valor) {
		this.id_ciudad = id_ciudad;
		this.nombre_ciudad = nombre_ciudad;
		this.pais = pais;
		this.valor = valor;
	}
	
	public int getId_ciudad() {
		return id_ciudad;
	}
	public void setId_ciudad(int id_ciudad) {
		this.id_ciudad = id_ciudad;
	}
	public String getNombre_ciudad() {
		return nombre_ciudad;
	}
	public void setNombre_ciudad(String nombre_ciudad) {
		this.nombre_ciudad = nombre_ciudad;
	}
	
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
}
