package com.jcertif.dao.hibernate.participant;

import com.jcertif.bo.participant.ProfilUtilisateur;
import com.jcertif.dao.api.participant.ProfilUtilisateurDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

import org.springframework.stereotype.Repository;


/**
 * Implementation Hibernate du DAO pour ProfilUtilisateur.
 * 
 * @author Douneg
 * 
 */
@Repository
public class ProfilUtilisateurDAOHibernate extends
		AbstractHibernateGenericDAO<ProfilUtilisateur, Long> implements ProfilUtilisateurDAO {

}
