/**
 * 
 */
package com.jcertif.service.impl.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.presentation.Sujet;
import com.jcertif.dao.api.presentation.SujetDAO;
import com.jcertif.service.AbstractService;
import com.jcertif.service.api.presentation.SujetService;

/**
 * @author rossi
 *
 */
@Service
public class SujetServiceImpl  extends AbstractService<Sujet, Long, SujetDAO> implements SujetService {

    @Autowired
    private SujetDAO sujetDAO;

    @Override
    public SujetDAO getDAO() {
        return sujetDAO;
    }

    @Override
    public void setDAO(SujetDAO sujetDAO) {
        this.sujetDAO = sujetDAO;
    }
}
