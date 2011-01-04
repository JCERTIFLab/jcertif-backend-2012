package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.*;
import com.jcertif.dao.CeduleParticipantDAO;

@Repository
public class CeduleParticipantDAOHibernate extends
		AbstractHibernateGenericDAO<CeduleParticipant, Long> implements
		CeduleParticipantDAO {

}
