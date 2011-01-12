package com.jcertif.dao.hibernate;

import com.jcertif.bo.ProfilUtilisateur;
import com.jcertif.dao.ProfilUtilisateurDAO;
import org.springframework.stereotype.Repository;


/**
 * Impl�mentation Hibernate du DAO pour ProfilUtilisateur.
 * 
 * @author Douneg
 * 
 */
@Repository
public class ProfilUtilisateurDAOHibernate extends
		AbstractHibernateGenericDAO<ProfilUtilisateur, Long> implements ProfilUtilisateurDAO {

}
