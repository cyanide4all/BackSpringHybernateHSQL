package com.qindel.webapp.modelo.entities;

import java.util.ArrayList;
import java.util.HashMap;
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

	/**
	 * Devuelve en forma de lista de mapas todas las ciudades dadas de alta en el sistema indicando, 
	 * para cada una de ellas, el número de veces que ha sido sede de unos juegos olímpicos; 
	 * distinguiendo entre el número de veces que lo ha sido para juegos de invierno y de verano. 
	 * Además, se mostrará también el dato "valor" que puede ser nulo para una ciudad concreta y 
	 * en cuyo caso se mostraría el definido para el país. 
	 * 
	 * @return dicha lista de mapas
	 */
	public ArrayList<HashMap<String, String>> getCiudadesCompleto();

}
