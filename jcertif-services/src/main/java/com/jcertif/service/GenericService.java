/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcertif.service;

import com.jcertif.dao.api.GenericDAO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Douneg
 */
public interface GenericService<T, PK extends Serializable, S extends GenericDAO<T, PK>> {

    List<T> findAll();

    /**
     *
     * @param key
     * @return une Conférence
     */
    T findById(PK key);

    /**
     * @param entite
     */
    void remove(T entite);

    /**
     *
     * @param entite
     * @return
     */
    T save(T entite);

    void setDAO(S service);

    /**
     *
     * @param entite
     * @return
     */
    T update(T entite);

}
