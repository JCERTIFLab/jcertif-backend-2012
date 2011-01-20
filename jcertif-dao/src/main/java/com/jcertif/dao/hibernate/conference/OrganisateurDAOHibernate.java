/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.dao.hibernate.conference;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.conference.Organisateur;
import com.jcertif.dao.api.conference.OrganisateurDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * @author chrisbel
 */
@Repository
public class OrganisateurDAOHibernate extends
		AbstractHibernateGenericDAO<Organisateur, Long> implements OrganisateurDAO {


}
