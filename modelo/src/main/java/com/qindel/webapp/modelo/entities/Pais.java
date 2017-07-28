package com.qindel.webapp.modelo.entities;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Clase entity asociada a la tabla aplicacion_web.pais. Guarda toda la información relativa a un país.
 * 
 * @author richie
 * 
 */
public class Pais implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2L;

	/** Identificador del país. */
	private Integer idPais;

	/** Nombre del país. */
	private String nombrePais;

	/** Código ISO de dos caracteres del país. */
	private String codigoPais;
	/**
	 * Valor asignado al conjunto del país.
	 */
	private int valorPais;

	/**
	 * Constructor por defecto.
	 */
	public Pais() {
		super();
	}

	/**
	 * Constructor que inicializa todos los atributos de la clase.
	 * 
	 * @param idPais
	 *            identificador del país.
	 * @param nombrePais
	 *            nombre del país.
	 * @param codigoPais
	 *            código ISO de dos caracteres del país.
	 * @param valorPais
	 *            valor del país.
	 */
	public Pais(Integer idPais, String nombrePais, String codigoPais, int valorPais) {
		this.idPais = idPais;
		this.nombrePais = nombrePais;
		this.codigoPais = codigoPais;
		this.valorPais = valorPais;
	}

	/**
	 * Gets the id pais.
	 * 
	 * @return the idPais
	 */
	public Integer getIdPais() {
		return idPais;
	}

	/**
	 * Sets the id pais.
	 * 
	 * @param idPais
	 *            the idPais to set
	 */
	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	/**
	 * Gets the nombre pais.
	 * 
	 * @return the nombrePais
	 */
	public String getNombrePais() {
		return nombrePais;
	}

	/**
	 * Sets the nombre pais.
	 * 
	 * @param nombrePais
	 *            the nombrePais to set
	 */
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	/**
	 * Gets the codigo pais.
	 * 
	 * @return the codigoPais
	 */
	public String getCodigoPais() {
		return codigoPais;
	}

	/**
	 * Sets the codigo pais.
	 * 
	 * @param codigoPais
	 *            the codigoPais to set
	 */
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	/**
	 * Gets the valor pais.
	 * 
	 * @return the valorPais
	 */
	public int getValorPais() {
		return valorPais;
	}

	/**
	 * Sets the valor pais.
	 * 
	 * @param valorPais
	 *            the valorPais to set
	 */
	public void setValorPais(int valorPais) {
		this.valorPais = valorPais;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.idPais).toHashCode();
	}

	/**
	 * Dos países son iguales si tienen el mismo identificador.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return new EqualsBuilder().append(this.idPais, other.idPais).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pais [idPais=").append(idPais).append(", nombrePais=").append(nombrePais)
				.append(", codigoPais=").append(codigoPais).append(", valorPais=").append(valorPais).append("]");
		return builder.toString();
	}

}
