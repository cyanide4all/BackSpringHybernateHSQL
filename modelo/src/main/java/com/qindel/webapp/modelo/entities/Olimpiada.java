package com.qindel.webapp.modelo.entities;

import java.io.Serializable;

public class Olimpiada implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2L;
	private int id_ciudad;
	private String nombre_ciudad;
	private int id_pais;
	private String nombre_pais;
	private int valor;
	private String tipo_jjoo;
	private long veces_sede;
	
	public Olimpiada(int id_ciudad, String nombre_ciudad, int id_pais, String nombre_pais, int valor, String tipo_jjoo,
			long veces_sede) {
		this.id_ciudad = id_ciudad;
		this.nombre_ciudad = nombre_ciudad;
		this.id_pais = id_pais;
		this.nombre_pais = nombre_pais;
		this.valor = valor;
		this.tipo_jjoo = tipo_jjoo;
		this.veces_sede = veces_sede;
	}
	
	public Olimpiada(int id_ciudad, String nombre_ciudad, int id_pais, String nombre_pais, int valor) {
		this.id_ciudad = id_ciudad;
		this.nombre_ciudad = nombre_ciudad;
		this.id_pais = id_pais;
		this.nombre_pais = nombre_pais;
		this.valor = valor;
		this.tipo_jjoo = "N/A";
		this.veces_sede = 0;
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
	public int getId_pais() {
		return id_pais;
	}
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}
	public String getNombre_pais() {
		return nombre_pais;
	}
	public void setNombre_pais(String nombre_pais) {
		this.nombre_pais = nombre_pais;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getTipo_jjoo() {
		return tipo_jjoo;
	}
	public void setTipo_jjoo(String tipo_jjoo) {
		this.tipo_jjoo = tipo_jjoo;
	}
	public long getVeces_sede() {
		return veces_sede;
	}
	public void setVeces_sede(long veces_sede) {
		this.veces_sede = veces_sede;
	}
	
	
	
}
