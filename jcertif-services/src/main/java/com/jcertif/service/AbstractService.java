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
    public abstract S getDAO();

    @Override
    public abstract void setDAO(S dao);

    @Override
    public List<T> findAll() {
        return getDAO().findAll();
    }

    /**
     *
     * @param key
     * @return une entite
     */
    @Override
    public T findById(PK key) {
        return getDAO().findById(key);
    }

    /**
     *
     * @param entite
     * @return
     */
    @Override
    @Transactional
    public T save(T entite) {
        getDAO().persist(entite);
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
        return getDAO().merge(entite);
    }

    /**
     * @param entite
     */
    @Override
    @Transactional
    public void remove(T entite) {
        getDAO().remove(entite);
    }
}
