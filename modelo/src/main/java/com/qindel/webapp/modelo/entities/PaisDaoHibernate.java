package com.qindel.webapp.modelo.entities;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
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
		/* CONSULTA
		 * 
			"select C.ID_CIUDAD, C.NOMBRE_CIUDAD, "
			+ " P.ID_PAIS, P.NOMBRE_PAIS, " + "	ifnull(C.VALOR_CIUDAD, P.VALOR_PAIS) as valor,"
			+ "	sub.DESCRIPCION_TIPO as Descripcion,"
			+ "	(select count(sede_jjoo.AÑO) from sede_jjoo where sede_jjoo.SEDE=C.ID_CIUDAD) as veces_sede "
			+ " from pais as P, ciudad as C "
			+ " left join (select DESCRIPCION_TIPO, SEDE from tipo_jjoo as TJ, sede_jjoo as SJ where TJ.ID_TIPO_JJOO=SJ.ID_TIPO_JJOO) as sub "
			+ " on sub.SEDE = C.ID_CIUDAD " + "where C.ID_PAIS = P.ID_PAIS"
		*/
		/* OPCION 1 (Borrow prepareStatement from pool failed)
		 * 
			Session sessionHb = getSessionFactory().getCurrentSession();
			String sql = "select C.ID_CIUDAD, C.NOMBRE_CIUDAD, "
					+ " P.ID_PAIS, P.NOMBRE_PAIS, " + "	ifnull(C.VALOR_CIUDAD, P.VALOR_PAIS) as valor,"
					+ "	sub.DESCRIPCION_TIPO as Descripcion,"
					+ "	(select count(sede_jjoo.AÑO) from sede_jjoo where sede_jjoo.SEDE=C.ID_CIUDAD) as veces_sede "
					+ " from pais as P, ciudad as C "
					+ " left join (select DESCRIPCION_TIPO, SEDE from tipo_jjoo as TJ, sede_jjoo as SJ where TJ.ID_TIPO_JJOO=SJ.ID_TIPO_JJOO) as sub "
					+ " on sub.SEDE = C.ID_CIUDAD " + "where C.ID_PAIS = P.ID_PAIS";
			SQLQuery query = sessionHb.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			return (List<Olimpiada>) query.list();
		 */
		
		/*OPCION 2 (TODO)
		 * return getSessionFactory().getCurrentSession().createQuery("select new com.qindel.webapp.modelo.entities.Olimpiada()").list();
		 */
		
		/* OPCION 3 (FAIL)
		 * "select p, c, s, t, COALESCE(C.VALOR_CIUDAD, P.VALOR_PAIS) from pais as P inner join ciudad as C on C.ID_PAIS = P.ID_PAIS left join sede_jjoo S on C.ID_CIUDAD = S.SEDE left join tipo_jjoo T on T.ID_TIPO_JJOO = S.ID_TIPO_JJOO"
		 */
		
		/* OPCION 4 (FAIL)
		 * return getSessionFactory().getCurrentSession().createQuery("select new com.qindel.webapp.modelo.entities.Olimpiada(c.id_ciudad, c.nombre_ciudad, p.id_pais, p.nombre_pais) from Ciudad as c, Pais as p").list();
		 */
	
		/* OPCION 5 (FAIL)
		 * return getSessionFactory().getCurrentSession().createQuery("from Olimpiada").list();
		 */

		return getSessionFactory().getCurrentSession().createQuery("select new com.qindel.webapp.modelo.entities.Olimpiada(c.id_ciudad, c.nombre_ciudad, p.idPais, p.nombrePais, coalesce(c.valor, p.valorPais)) from Ciudad as c inner join c.pais as p").list();
	}
}
