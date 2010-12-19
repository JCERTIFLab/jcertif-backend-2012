package com.jcertif.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic DAO Interface.
 * 
 * @author rossi.oddet
 * 
 * @param <T>
 *            persistent type.
 * @param <PK>
 *            Primary key type
 */
public interface GenericDAO<T, PK extends Serializable> extends DAO {

	T getReference(PK id);

	T findById(PK id);

	List<T> findAll();

	List<T> findAllWithSort(String sortedPropertyName, boolean ascending);

	void persist(T entity);

	T merge(T entity);

	void remove(T entity);

	void flush();

	void clear();

}
