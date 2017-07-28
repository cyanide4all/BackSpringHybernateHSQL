package com.qindel.webapp.modelo.entities;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LibroDaoHibernate extends HibernateDaoSupport implements LibroDao {

	@Override
	public Libro findLibro(int idLibro) {
		return (Libro) getSessionFactory().getCurrentSession().get(Libro.class, idLibro);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Libro> findAll() {
		return getSessionFactory().getCurrentSession().createQuery("from Libro").list();
	}

	@Override
	public void delete(int id) {
		Session sesion = getSessionFactory().openSession();
		Libro libro = (Libro) sesion.load(Libro.class, id);
		if (libro != null) {
	    	sesion.delete(libro);
	    }
	}
	
}
