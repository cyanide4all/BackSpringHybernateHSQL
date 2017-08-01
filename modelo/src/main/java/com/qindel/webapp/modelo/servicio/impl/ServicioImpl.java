package com.qindel.webapp.modelo.servicio.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qindel.webapp.modelo.dtos.LibroDto;
import com.qindel.webapp.modelo.dtos.PaisDto;
import com.qindel.webapp.modelo.entities.Libro;
import com.qindel.webapp.modelo.entities.LibroDao;
import com.qindel.webapp.modelo.entities.Pais;
import com.qindel.webapp.modelo.entities.PaisDao;
import com.qindel.webapp.modelo.servicio.Servicio;

/**
 * Esta clase se encarga de la implementación del servicio web.
 * 
 * @author richie
 * 
 */
@Service("servicioImpl")
public class ServicioImpl implements Servicio {

	private PaisDao paisDao;
	private LibroDao libroDao;

	/**
	 * Logger.
	 */
	private final Logger log = LoggerFactory.getLogger(ServicioImpl.class);

	@Override
	@Transactional(readOnly = true)
	public List<PaisDto> findAllPaises() {
		List<Pais> paises = paisDao.findAll();
		List<PaisDto> paisesDto = new ArrayList<PaisDto>(paises.size());
		for (Pais pais : paises) {
			paisesDto
					.add(new PaisDto(pais.getIdPais(), pais.getNombrePais(), pais.getCodigoPais(), pais.getValorPais()));
		}
		return paisesDto;
	}

	@Override
	@Transactional(readOnly = true)
	public List<LibroDto> findAllLibros() {
		List<Libro> libros = libroDao.findAll();
		this.log.debug("libros antes: " + libros);
		Collections.sort(libros, new Comparator<Libro>() {
			@Override
			public int compare(Libro o1, Libro o2) {
				return o1.getTitulo().compareTo(o2.getTitulo());
			}
		});
		this.log.debug("libros despues: " + libros);
		List<LibroDto> librosDto = new ArrayList<LibroDto>(libros.size());
		for (Libro libro : libros) {
			librosDto.add(new LibroDto(libro.getIdLibro(), libro.getTitulo(), libro.getAutor()));
		}
		return librosDto;
	}
	
	@Override
	@Transactional
	public void deleteLibro(int id) {
		libroDao.delete(id);
	}

	@Override
	@Transactional
	public void modifyLibro(int id, Libro libro) {
		libroDao.modifyLibro(id, libro);
	}
	
	/**
	 * @return the paisDao
	 */
	public PaisDao getPaisDao() {
		return paisDao;
	}

	/**
	 * @param paisDao
	 *            the paisDao to set
	 */
	public void setPaisDao(PaisDao paisDao) {
		this.paisDao = paisDao;
	}

	/**
	 * @return the libroDao
	 */
	public LibroDao getLibroDao() {
		return libroDao;
	}

	/**
	 * @param libroDao
	 *            the libroDao to set
	 */
	public void setLibroDao(LibroDao libroDao) {
		this.libroDao = libroDao;
	}

}
