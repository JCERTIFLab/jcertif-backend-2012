/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.Organisateur;
import com.jcertif.dao.OrganisateurDAO;

/**
 * @author chrisbel
 */
@Repository
public class OrganisateurDAOHibernate extends
		AbstractHibernateGenericDAO<Organisateur, Long> implements OrganisateurDAO {


}
