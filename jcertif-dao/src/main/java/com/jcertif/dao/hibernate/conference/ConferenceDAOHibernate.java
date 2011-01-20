/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.dao.hibernate.conference;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.conference.Conference;
import com.jcertif.dao.api.conference.ConferenceDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * @author chrisbel
 */
@Repository
public class ConferenceDAOHibernate extends
AbstractHibernateGenericDAO<Conference, Long> implements ConferenceDAO{

}
