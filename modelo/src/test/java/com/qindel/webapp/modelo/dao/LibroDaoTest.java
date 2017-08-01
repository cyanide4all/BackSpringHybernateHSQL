package com.qindel.webapp.modelo.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.qindel.webapp.modelo.entities.Libro;
import com.qindel.webapp.modelo.entities.LibroDao;

/**
 * Clase para crear los test en el Dao de libros
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml", "classpath:spring-test-context.xml" })
@TransactionConfiguration(defaultRollback = true, transactionManager = "txManager")
@Transactional
public class LibroDaoTest {

	static String AUTOR = "Autorito de los autores";
	static String TITULO = "Nombre de libro impresionante";
	
	/** El dao de libros. */
	@Autowired
	LibroDao libroDao;

	/**
	 * Verifica que la tabla de libros tiene alguna fila.
	 */
	@Test
	public void testNotEmptyLibroTable() {
		List<Libro> libroList = libroDao.findAll();
		Assert.assertTrue(!libroList.isEmpty());
	}
	
	/**
	 * Verifica que la tabla consta de exactamente 9 elementos
	 */
	@Test
	public void testFindAll() {
		List<Libro> libroList = libroDao.findAll();
		int count = libroList.size();
		Assert.assertEquals(count, 9);
	}	
	
	/**
	 * Verifica que se ha borrado el primer libro obtenido, y que solo ese ha sido eliminado
	 */
	@Test
	public void testDelete() {
		List<Libro> libroList = libroDao.findAll();
		int countInicial = libroList.size();	
		Libro toDelete = libroList.get(0);
		libroDao.delete(toDelete.getIdLibro());
		int countFinal = libroDao.findAll().size();
		Assert.assertEquals(countFinal, countInicial-1);
		Assert.assertNull(libroDao.findLibro(toDelete.getIdLibro()));
	}
	
	/**
	 * Verifica que se ha modificado el libro en cuestión con los datos adecuados
	 */
	@Test
	public void testModify() {
		List<Libro> libroList = libroDao.findAll();
		Libro toModify = libroList.get(0);
		toModify.setAutor(AUTOR);
		toModify.setTitulo(TITULO);
		libroDao.modifyLibro(toModify.getIdLibro(), toModify);
		Libro toCheck = libroDao.findLibro(toModify.getIdLibro());
		Assert.assertEquals(AUTOR, toCheck.getAutor());
		Assert.assertEquals(TITULO, toCheck.getTitulo());
	}
	
	
}
