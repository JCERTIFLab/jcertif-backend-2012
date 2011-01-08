package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.OrganisateurCentreConf;
import com.jcertif.dao.OrganisteurCentreConfDAO;

/**
 * @author rossi.oddet
 * 
 */
@Repository
public class OrganisteurCentreConfDAOHibernate extends
		AbstractHibernateGenericDAO<OrganisateurCentreConf, Long> implements
		OrganisteurCentreConfDAO {

}
