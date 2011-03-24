/**
 * 
 */
package com.jcertif.dao.hibernate.conference;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.conference.Faq;
import com.jcertif.dao.api.conference.FaqDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * @author rossi
 * 
 */
@Repository
public class FaqDAOHibernate extends AbstractHibernateGenericDAO<Faq, Long> implements FaqDAO {

}
