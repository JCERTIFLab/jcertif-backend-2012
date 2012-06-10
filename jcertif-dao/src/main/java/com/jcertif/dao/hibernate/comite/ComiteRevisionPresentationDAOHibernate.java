package com.jcertif.dao.hibernate.comite;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.comite.ComiteRevisionPresentation;
import com.jcertif.bo.comite.ComiteRevisionPresentationPK;
import com.jcertif.dao.api.comite.ComiteRevisionPresentationDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Implementation Hibernate pour {@link ComiteRevisionPresentationDAO}.
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
