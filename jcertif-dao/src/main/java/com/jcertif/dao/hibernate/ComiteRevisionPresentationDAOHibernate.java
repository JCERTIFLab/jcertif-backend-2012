package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.ComiteRevisionPresentation;
import com.jcertif.bo.ComiteRevisionPresentationPK;
import com.jcertif.dao.ComiteRevisionPresentationDAO;

/**
 * Implémentation Hibernate pour {@link ComiteRevisionPresentationDAO}.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class ComiteRevisionPresentationDAOHibernate
		extends
		AbstractHibernateGenericDAO<ComiteRevisionPresentation, ComiteRevisionPresentationPK>
		implements ComiteRevisionPresentationDAO {

}
