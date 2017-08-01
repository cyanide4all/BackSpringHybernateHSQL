package com.qindel.webapp.modelo.servicio;

import java.util.List;

import com.qindel.webapp.modelo.dtos.LibroDto;
import com.qindel.webapp.modelo.dtos.PaisDto;
import com.qindel.webapp.modelo.entities.Libro;

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
}
