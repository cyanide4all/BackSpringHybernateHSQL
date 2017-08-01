package com.qindel.webapp.modelo.entities;

import java.util.ArrayList;
import java.util.HashMap;
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

	@Override
	public ArrayList<HashMap<String, String>> getCiudadesCompleto() {
		getSessionFactory()
		.getCurrentSession()
		.createSQLQuery("select P.ID_PAIS, P.NOMBRE_PAIS as Pais, "
					+ "	C.ID_CIUDAD, C.NOMBRE_CIUDAD as Ciudad, " + "	ifnull(C.VALOR_CIUDAD, P.VALOR_PAIS) as Valor,"
					+ "	sub.DESCRIPCION_TIPO as Descripcion,"
					+ "	(select count(sede_jjoo.AÑO) from sede_jjoo where sede_jjoo.SEDE=C.ID_CIUDAD) as Numero_veces_sede "
					+ "from pais as P, ciudad as C "
					+ "left join (select DESCRIPCION_TIPO, SEDE from tipo_jjoo as TJ, sede_jjoo as SJ where TJ.ID_TIPO_JJOO=SJ.ID_TIPO_JJOO) as sub "
					+ "on sub.SEDE = C.ID_CIUDAD " + "where C.ID_PAIS = P.ID_PAIS");
		//TODO PORQUE ESTO ESTA DEVOLVIENDO NULL
		return null;
	}

}
