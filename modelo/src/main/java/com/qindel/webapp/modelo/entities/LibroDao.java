package com.qindel.webapp.modelo.entities;

import java.util.List;

/**
 * Interfaz con los métodos de acceso a los libros en la base de datos.
 * 
 * @author richie
 *
 */
public interface LibroDao {

	/**
	 * Devuelve los datos del libro con identificador <code>idLibro</code>.
	 *
	 * @param idLibro Identificador del libro buscado.
	 * @return Los datos del libro con el identificador <code>idLibro</code> o <code>null</code> si no encuentra ningún
	 * libro con ese identificador.
	 */
	public Libro findLibro(int idLibro);
	
	/**
	 * Devuelve una lista de todos los libros dados de alta en el sistema sin utilizar ningún tipo de filtro.
	 * 
	 * @return La lista de todos los libros dados de alta (puede estar vacía).
	 */
	public List<Libro> findAll();

	/**
	 * Elimina un libro de la base de datos
	 * @param id la id del libro
	 */
	public void delete(int id);

	/**
	 * Modifica un libro en la base de datos
	 * @param id es la id del libro
	 * @param libro es un objeto de tipo libro con el resto de datos necesarios
	 */
	public void modifyLibro(int id, Libro libro);
}
