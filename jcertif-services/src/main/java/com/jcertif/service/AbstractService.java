/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.service;

import com.jcertif.dao.api.GenericDAO;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Douneg
 */
public abstract class AbstractService<T, PK extends Serializable, S extends GenericDAO<T, PK>> implements GenericService<T, PK, S> {

    /**
     *
     * @return list des entites
     */
    @Autowired
    S service;

    @Override
    public List<T> findAll() {
        return service.findAll();
    }

    @Override
    public void setService(S service) {
        this.service = service;
    }

    

    /**
     *
     * @param key
     * @return une Conférence
     */
    @Override
    public T findById(PK key) {
        return service.findById(key);
    }

    /**
     *
     * @param entite
     * @return
     */
    @Override
    public T save(T entite) {
        return service.merge(entite);
    }

    /**
     *
     * @param entite
     * @return
     */
    @Override
    public T update(T entite) {
        return service.merge(entite);
    }

    /**
     * @param entite
     */
    @Override
    public void remove(T entite) {
        service.remove(entite);
    }
}
