package com.jcertif.dao.hibernate.cedule;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jcertif.bo.cedule.StatutCedule;
import com.jcertif.dao.api.cedule.StatutCeduleDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Implementation Hibernate d'acces aux donnees du statut cedule.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class StatutCeduleDAOHibernate extends
		AbstractHibernateGenericDAO<StatutCedule, Long> implements
		StatutCeduleDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StatutCedule findByCode(String code) {
		return (StatutCedule)getCurrentSession().createCriteria(StatutCedule.class)
		.add(Restrictions.eq("code", code)).uniqueResult();
	}

}
