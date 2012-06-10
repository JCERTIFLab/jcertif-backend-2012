package com.jcertif.dao.hibernate.presentation;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jcertif.bo.presentation.StatutApprobation;
import com.jcertif.dao.api.presentation.StatutApprobationDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Implementation Hibernate de l'acces aux donnees statut d'approbation.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class StatutApprobationDAOHibernate extends
		AbstractHibernateGenericDAO<StatutApprobation, Long> implements
		StatutApprobationDAO {

	@Override
	public List<StatutApprobation> findByCode(String code) {
		return getCurrentSession().createCriteria(StatutApprobation.class)
		.add(Restrictions.eq("codeStatut", code)).list();

	}

}
