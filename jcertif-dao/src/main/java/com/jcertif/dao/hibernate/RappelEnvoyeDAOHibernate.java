package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.RappelEnvoye;
import com.jcertif.bo.RappelEnvoyePK;
import com.jcertif.dao.RappelEnvoyeDAO;

/**
 * Implémentation Hibernate du BO {@link RappelEnvoye}.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class RappelEnvoyeDAOHibernate extends
		AbstractHibernateGenericDAO<RappelEnvoye, RappelEnvoyePK> implements
		RappelEnvoyeDAO {

}
