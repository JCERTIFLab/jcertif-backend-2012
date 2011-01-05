package com.jcertif.dao.hibernate;

import com.jcertif.bo.PresentationAuteur;
import com.jcertif.bo.PresentationAuteurPK;
import com.jcertif.dao.PresentationAuteurDAO;
import org.springframework.stereotype.Repository;

/**
 * Implémentation Hibernate du DAO pour PresentationAuteur.
 * 
 * @author Douneg
 * 
 */
@Repository
public class PresentationAuteurDAOHibernate extends AbstractHibernateGenericDAO<PresentationAuteur, PresentationAuteurPK> implements PresentationAuteurDAO {
}
