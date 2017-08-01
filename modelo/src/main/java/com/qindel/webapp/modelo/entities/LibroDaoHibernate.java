package com.qindel.webapp.modelo.entities;

import java.util.List;

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

	public void delete(int id) {
		Libro libro = this.findLibro(id);
		if (libro != null) {
			getSessionFactory().getCurrentSession().delete(libro);
	    }
	}

	@Override
	public void modifyLibro(int id, Libro libro) {
		Libro toUpdate = this.findLibro(id);
		toUpdate.setAutor(libro.getAutor());
		toUpdate.setTitulo(libro.getTitulo());
		getSessionFactory().getCurrentSession().saveOrUpdate(toUpdate);
	}
	
}
