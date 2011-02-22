/**
 * 
 */
package com.jcertif.service.impl.cedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.cedule.CeduleSalle;
import com.jcertif.dao.api.cedule.CeduleSalleDAO;
import com.jcertif.service.AbstractService;
import com.jcertif.service.api.cedule.CeduleSalleService;

/**
 * @author rossi.oddet
 * 
 */
@Service
public class CeduleSalleServiceImpl extends AbstractService<CeduleSalle, Long, CeduleSalleDAO> implements
        CeduleSalleService {

    @Autowired
    private CeduleSalleDAO ceduleSalleDAO;

    @Override
    public CeduleSalleDAO getDAO() {
        return ceduleSalleDAO;
    }

    @Override
    public void setDAO(CeduleSalleDAO dao) {
        this.ceduleSalleDAO = dao;
    }
}
