package com.qindel.webapp.modelo.entities;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PaisDaoHibernate extends HibernateDaoSupport implements PaisDao {

	@Override
	public Pais findPais(int idPais) {
		return (Pais) getSessionFactory().getCurrentSession().get(Pais.class, idPais);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> findAll() {
		return getSessionFactory().getCurrentSession().createQuery("from Pais").list();
	}

}
