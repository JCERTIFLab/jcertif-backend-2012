package com.jcertif.dao.hibernate.cedule;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.dao.api.cedule.EvenementDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Impl�mentation Hibernate de l'acc�s aux donn�es Evenement.
 * 
 * @author Douneg
 * 
 */
@Repository
public class EvenementDAOHibernate extends AbstractHibernateGenericDAO<Evenement, Long> implements
		EvenementDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Evenement> findByConference(Long idConference) {
		return getCurrentSession().createQuery(
				"select e from Evenement e where e.propositionPresentation.conference.id="
						+ idConference).list();

	}

}
