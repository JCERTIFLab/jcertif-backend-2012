package com.jcertif.dao.hibernate.comite;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.comite.RappelEnvoye;
import com.jcertif.bo.comite.RappelEnvoyePK;
import com.jcertif.dao.api.comite.RappelEnvoyeDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

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
