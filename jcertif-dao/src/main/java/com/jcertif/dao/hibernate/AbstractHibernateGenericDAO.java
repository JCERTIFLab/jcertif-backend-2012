package com.jcertif.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.jcertif.dao.GenericDAO;

/**
 * Implementation of GenericDAO with Hibernate.
 * 
 * @param <T>
 *            the persistent type
 * @param <PK>
 *            the primary key type of the persistent object
 */
public abstract class AbstractHibernateGenericDAO<T, PK extends Serializable>
		implements GenericDAO<T, PK> {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AbstractHibernateGenericDAO.class);

	/**
	 * The session factory hibernate.
	 */
	private SessionFactory sessionFactory;

	/**
	 * The persistent class.
	 */
	private final Class<T> persistentClass;

	/**
	 * The constructor.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public AbstractHibernateGenericDAO() {
		super();
		final ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.persistentClass = (Class<T>) type.getActualTypeArguments()[0];
	}

	/**
	 * @return the current session.
	 */
	protected Session getCurrentSession() {
		return SessionFactoryUtils.getSession(this.sessionFactory, true);
	}

	/**
	 * {@inheritDoc}
	 */
	public void clear() {
		LOGGER.debug("Clearing session");
		this.getCurrentSession().clear();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		final List<T> result = this.getCurrentSession()
				.createCriteria(this.persistentClass).list();
		LOGGER.debug("findAll() persistentClass={}, result={}",
				this.persistentClass, result.size());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAllWithSort(final String sortedPropertyName,
			final boolean ascending) {
		final Criteria criteria = this.getCurrentSession().createCriteria(
				this.persistentClass);

		if (ascending) {
			criteria.addOrder(Order.asc(sortedPropertyName));
		} else {
			criteria.addOrder(Order.desc(sortedPropertyName));
		}

		final List<T> result = criteria.list();

		LOGGER.debug("findAllWithSort() persistentClass={}, result={}",
				this.persistentClass, result.size());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public T findById(final PK id) {
		final T result = (T) this.getCurrentSession().get(this.persistentClass,
				id);
		LOGGER.debug(
				"findById() with id={} returns {}",
				new Object[] { this.persistentClass, id, result });
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void flush() {
		LOGGER.debug("Flushing session.");
		this.getCurrentSession().flush();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public T getReference(final PK id) {
		LOGGER.debug(
				"Loading peristentClass={},id={}",
				this.persistentClass, id);
		return (T) this.getCurrentSession().load(this.persistentClass, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public T merge(final T entity) {
		LOGGER.debug("Merging entity {}", entity);
		return (T) this.getCurrentSession().merge(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	public void persist(final T entity) {
		LOGGER.debug("Persisting entity {}", entity);
		this.getCurrentSession().persist(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(final T entity) {
		if (entity == null) {
			LOGGER.warn("Entity is null.");
		} else {
			LOGGER.debug("Removing entity {}", entity);
			this.getCurrentSession().delete(entity);
		}
	}

	/**
	 * Modifie sessionFactory.
	 * 
	 * @param sessionFactory
	 *            sessionFactory à modifier
	 */
	@Required
	@Autowired
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Retourne persistentClass.
	 * 
	 * @return persistentClass
	 */
	protected Class<T> getPersistentClass() {
		return this.persistentClass;
	}

}
