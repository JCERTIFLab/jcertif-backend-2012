package com.jcertif.dao.hibernate.comite;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.comite.ComiteOrganisation;
import com.jcertif.dao.api.comite.ComiteOrganisationDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Implementation Hibernate d'acces aux donnees ComiteOrganisation.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class ComiteOrganisationDAOHibernate extends
		AbstractHibernateGenericDAO<ComiteOrganisation, Long> implements
		ComiteOrganisationDAO {

}
