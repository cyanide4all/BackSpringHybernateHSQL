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

	@SuppressWarnings("unchecked")
	@Override
	public List<Olimpiada> getCiudadesCompleto() {
		return getSessionFactory()
				.getCurrentSession()
				.createQuery("select "
					+ 		"new com.qindel.webapp.modelo.entities.Olimpiada("
					+ 		"c.id_ciudad, c.nombre_ciudad, p.idPais, p.nombrePais, "
					+ 		"coalesce(c.valor, p.valorPais), coalesce(tj.descripcion_tipo, 'N/A'), "
					+ 		"(select count(sj.anyo) from Sede_jjoo as sj where sj.sede.id_ciudad = c.id_ciudad )"
					+ 		") "
					+ 		"from Sede_jjoo as s "
					+ 		"right join s.sede as c "
					+ 		"left join s.tipo_jjoo as tj "
					+ 		"inner join c.pais as p "
					+ 		"order by c.id_ciudad")
				.list();
		}
}
