/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.ParticulariteSalle;
import com.jcertif.dao.ParticulariteSalleDAO;

/**
 * @author chrisbel
 */
@Repository
public class ParticulariteSalleDAOHibernate extends
		AbstractHibernateGenericDAO<ParticulariteSalle, Long> implements ParticulariteSalleDAO{

}
