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
}
