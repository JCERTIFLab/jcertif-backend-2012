package com.jcertif.dao.hibernate.conference;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.conference.CentreConference;
import com.jcertif.dao.api.conference.CentreConferenceDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * 
 * @author Mamadou
 *
 */
@Repository
public class CentreConferenceDAOHibernate extends
		AbstractHibernateGenericDAO<CentreConference, Long> implements CentreConferenceDAO {

}
