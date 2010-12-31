package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.StatutCedule;
import com.jcertif.dao.StatutCeduleDAO;

/**
 * Implémentation Hibernate d'accès aux données du statut cedule.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class StatutCeduleDAOHibernate extends
		AbstractHibernateGenericDAO<StatutCedule, Long> implements
		StatutCeduleDAO {

}
