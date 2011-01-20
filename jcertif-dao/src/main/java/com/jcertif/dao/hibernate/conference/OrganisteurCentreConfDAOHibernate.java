package com.jcertif.dao.hibernate.conference;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.conference.OrganisateurCentreConf;
import com.jcertif.dao.api.conference.OrganisteurCentreConfDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * @author rossi.oddet
 * 
 */
@Repository
public class OrganisteurCentreConfDAOHibernate extends
		AbstractHibernateGenericDAO<OrganisateurCentreConf, Long> implements
		OrganisteurCentreConfDAO {

}
