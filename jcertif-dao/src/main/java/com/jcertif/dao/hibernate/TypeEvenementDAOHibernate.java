package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.TypeEvenement;
import com.jcertif.dao.TypeEvenementDAO;

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
