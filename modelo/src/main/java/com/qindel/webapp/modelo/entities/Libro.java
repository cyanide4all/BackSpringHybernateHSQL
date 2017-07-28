package com.qindel.webapp.modelo.entities;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Clase entity asociada a la tabla aplicacion_web.libro. Guarda toda la información relativa a un libro.
 * 
 * @author richie
 * 
 */
public class Libro implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2L;

	/** Identificador del libro. */
	private Integer idLibro;

	/** Título del libro. */
	private String titulo;

	/** Autor del libro. */
	private String autor;

	/**
	 * Constructor por defecto.
	 */
	public Libro() {
		super();
	}

	/**
	 * Constructor que incializa todos los campos.
	 * 
	 * @param idLibro
	 *            Identifcador del libro
	 * @param titulo
	 *            Título del libro
	 * @param autor
	 *            Autor del libro
	 */
	public Libro(Integer idLibro, String titulo, String autor) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
	}

	/**
	 * Gets the id libro.
	 * 
	 * @return the idLibro
	 */
	public Integer getIdLibro() {
		return idLibro;
	}

	/**
	 * Sets the id libro.
	 * 
	 * @param idLibro
	 *            the idLibro to set
	 */
	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	/**
	 * Gets the titulo.
	 * 
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Sets the titulo.
	 * 
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Gets the autor.
	 * 
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Sets the autor.
	 * 
	 * @param autor
	 *            the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.titulo).append(this.autor).toHashCode();
	}

	/**
	 * Dos libros son iguales si tienen el mismo título y el mismo autor.
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
		Libro other = (Libro) obj;
		return new EqualsBuilder().append(this.titulo, other.titulo).append(this.autor, other.autor).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Libro [idLibro=").append(idLibro).append(", titulo=").append(titulo).append(", autor=")
				.append(autor).append("]");
		return builder.toString();
	}

}
