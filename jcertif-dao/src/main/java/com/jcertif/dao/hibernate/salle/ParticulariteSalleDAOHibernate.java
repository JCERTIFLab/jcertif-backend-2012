/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.dao.hibernate.salle;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.salle.ParticulariteSalle;
import com.jcertif.dao.api.salle.ParticulariteSalleDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * @author chrisbel
 */
@Repository
public class ParticulariteSalleDAOHibernate extends
		AbstractHibernateGenericDAO<ParticulariteSalle, Long> implements ParticulariteSalleDAO{

}
