package com.qindel.webapp.web.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.qindel.webapp.modelo.dtos.LibroDto;
import com.qindel.webapp.modelo.dtos.PaisDto;
import com.qindel.webapp.modelo.entities.Libro;
import com.qindel.webapp.modelo.servicio.Servicio;

/**
 * Esta clase toma el rol de controlador en Spring MVC e implementa todos los métodos que serán llamados desde la
 * interfaz web. Este controlador funciona recibiendo datos y devolviendo datos en formato JSON.
 * 
 * @author richie
 *
 */
@Controller("controlador")
public class Controlador {
	
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Controlador.class);

	/**
	 * Instancia al servicio que implementa la lógica de negocio
	 */
	private Servicio servicio;

	/**
	 * Método asociado a la página de inicio.
	 * 
	 * @return La página de inicio.
	 */
	@RequestMapping(value = "/index.html")
	public ModelAndView index() {
		LOGGER.debug("/index.html");
		ModelAndView modelAndView = new ModelAndView("/index.html");
		return modelAndView;
	}

	/**
	 * Método que devuelve la lista de todos los países de la base de datos.
	 * @return Una lista en json con todos los países dados de alta en el sistema.
	 */
	@RequestMapping(value = "/paises", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<PaisDto> findAllPaises() {
		LOGGER.debug("/paises");
		List<PaisDto> listaPaises = servicio.findAllPaises();
		return listaPaises;
	}

	/**
	 * Método que devuelve la lista de todos los libros de la base de datos.
	 * @return Una lista en json con todos los libros dados de alta en el sistema.
	 */
	@RequestMapping(value = "/libros", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<LibroDto> findAllLibros() {
		LOGGER.debug("/libros");
		List<LibroDto> listaLibros = servicio.findAllLibros();
		return listaLibros;
	}
	
	/**
	 * Método que borra un libro de la base de datos.
	 * @param id es la id del libro.
	 */
	@RequestMapping(value = "/libros/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody void deleteLibro(@PathVariable("id") int id) {
		LOGGER.debug("/libros/"+id);
		servicio.deleteLibro(id);
	}
	
	/**
	 * Método que modifica un libro, pudiendo cambiar su título y autor
	 * @param id es la id del libro a modificar
	 * @param libro es un objeto de la clase Libro con los datos ya modificados
	 */
	@RequestMapping(value = "/libros/{id}", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody void modifyLibro(@PathVariable("id") int id, @RequestBody Libro libro) {
		LOGGER.debug("/libros/"+id);
		servicio.modifyLibro(id, libro);
		//servicio.modifyLibro(id, );
	}
	
	
	
	/**
	 * @return the servicio
	 */
	public Servicio getServicio() {
		return servicio;
	}

	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	
}
