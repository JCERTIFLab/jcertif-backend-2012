package com.jcertif.dao.hibernate.cedule;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.cedule.TypeEvenement;
import com.jcertif.dao.api.cedule.TypeEvenementDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Impl�mentation Hibernate pour l'acc�s aux donn�es {@link TypeEvenement}.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class TypeEvenementDAOHibernate extends
		AbstractHibernateGenericDAO<TypeEvenement, Long> implements
		TypeEvenementDAO {
}
