package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.ComiteOrganisation;
import com.jcertif.dao.ComiteOrganisationDAO;

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
