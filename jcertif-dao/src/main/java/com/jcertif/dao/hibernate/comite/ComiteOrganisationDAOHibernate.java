package com.jcertif.dao.hibernate.comite;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.comite.ComiteOrganisation;
import com.jcertif.dao.api.comite.ComiteOrganisationDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Impl�mentation Hibernate d'acc�s aux donn�es ComiteOrganisation.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class ComiteOrganisationDAOHibernate extends
		AbstractHibernateGenericDAO<ComiteOrganisation, Long> implements
		ComiteOrganisationDAO {

}
