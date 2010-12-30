package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.CentreConference;
import com.jcertif.dao.CentreConferenceDAO;

/**
 * 
 * @author Mamadou
 *
 */
@Repository
public class CentreConferenceDAOHibernate extends
		AbstractHibernateGenericDAO<CentreConference, Long> implements CentreConferenceDAO {

}
