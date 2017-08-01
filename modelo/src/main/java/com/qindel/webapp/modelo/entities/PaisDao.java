package com.qindel.webapp.modelo.entities;

import java.util.List;

/**
 * Interfaz con los métodos de acceso a los países en la base de datos.
 * 
 * @author richie
 *
 */
public interface PaisDao {

	/**
	 * Devuelve los datos del país con identificador <code>idPais</code>.
	 *
	 * @param idPais Identificador del país buscado.
	 * @return Los datos del país con el identificador <code>idPais</code> o <code>null</code> si no encuentra ningún
	 * país con ese identificador.
	 */
	public Pais findPais(int idPais);
	
	/**
	 * Devuelve una lista de todos los países dados de alta en el sistema sin utilizar ningún tipo de filtro.
	 * 
	 * @return La lista de todos los países dados de alta (puede estar vacía).
	 */
	public List<Pais> findAll();
}
