package com.jcertif.dao.hibernate.comite;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.comite.ComiteOrganisation;
import com.jcertif.dao.api.comite.ComiteOrganisationDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Implémentation Hibernate d'accès aux données ComiteOrganisation.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class ComiteOrganisationDAOHibernate extends
		AbstractHibernateGenericDAO<ComiteOrganisation, Long> implements
		ComiteOrganisationDAO {

}
