package com.qindel.webapp.modelo.servicio;

import java.util.List;

import com.qindel.webapp.modelo.dtos.LibroDto;
import com.qindel.webapp.modelo.dtos.PaisDto;
import com.qindel.webapp.modelo.entities.Libro;
import com.qindel.webapp.modelo.entities.Olimpiada;

/**
 * Esta interfaz define el servicio y los métodos que ofrece al mundo. En
 * este caso ofrece un único método: {@link #findAllPaises()}.
 *
 */
public interface Servicio {
	
	/**
	 * Este método se encarga de listar todos los países dados de alta en el sistema sin ningún tipo de filtro.
	 * @return La lista de países existentes en el sistema.
	 */
	public List<PaisDto> findAllPaises();

	/**
	 * Este método se encarga de listar todos los libros dados de alta en el sistema sin ningún tipo de filtro.
	 * @return La lista de libros existentes en el sistema.
	 */
	public List<LibroDto> findAllLibros();

	/**
	 * Este método elimina un libro de la base de datos
	 * @param id es la id del libro a eliminar
	 */
	public void deleteLibro(int id);

	/**
	 * 
	 * @param id
	 * @param titulo
	 * @param autor
	 */
	public void modifyLibro(int id, Libro libro);

	/**
	 * Este método devuelve todas las ciudades dadas de alta en el sistema indicando, 
	 * para cada una de ellas, el número de veces que ha sido sede de unos juegos olímpicos; 
	 * distinguiendo entre el número de veces que lo ha sido para juegos de invierno y de verano. 
	 * Además, se mostrará también el dato "valor" que puede ser nulo para una ciudad concreta y 
	 * en cuyo caso se mostraría el definido para el país. 
	 * @return La lista con los datos anteriormente indicados
	 */
	public List<Olimpiada> listCiudadesCompleto();
}
