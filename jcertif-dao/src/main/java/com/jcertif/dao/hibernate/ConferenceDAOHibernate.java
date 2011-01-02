/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.Conference;
import com.jcertif.dao.ConferenceDAO;

/**
 * @author chrisbel
 */
@Repository
public class ConferenceDAOHibernate extends
AbstractHibernateGenericDAO<Conference, Long> implements ConferenceDAO{

}
