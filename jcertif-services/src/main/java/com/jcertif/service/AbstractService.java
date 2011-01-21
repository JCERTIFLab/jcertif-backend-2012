/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.service;

import com.jcertif.dao.api.GenericDAO;
import java.io.Serializable;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Douneg
 */
public abstract class AbstractService<T, PK extends Serializable, S extends GenericDAO<T, PK>> implements GenericService<T, PK, S> {

    /**
     *
     * @return list des entites
     */
    public abstract S getService();

    @Override
    public abstract void setService(S service);

    @Override
    public List<T> findAll() {
        return getService().findAll();
    }

    /**
     *
     * @param key
     * @return une Conférence
     */
    @Override
    public T findById(PK key) {
        return getService().findById(key);
    }

    /**
     *
     * @param entite
     * @return
     */
    @Override
    @Transactional
    public T save(T entite) {
        getService().persist(entite);
        return entite;
    }

    /**
     *
     * @param entite
     * @return
     */
    @Override
    @Transactional
    public T update(T entite) {
        return getService().merge(entite);
    }

    /**
     * @param entite
     */
    @Override
    @Transactional
    public void remove(T entite) {
        getService().remove(entite);
    }
}
