/**
 * 
 */
package com.jcertif.service.impl.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.presentation.PropositionPresentation;
import com.jcertif.dao.api.presentation.PropositionPresentationDAO;
import com.jcertif.service.AbstractService;
import com.jcertif.service.api.presentation.PropositionPresentationService;

/**
 * @author rossi
 *
 */
@Service
public class PropositionPresentationServiceImpl extends AbstractService<PropositionPresentation, Long, PropositionPresentationDAO> implements PropositionPresentationService {

    @Autowired
    private PropositionPresentationDAO propositionPresentationDAO;

    @Override
    public PropositionPresentationDAO getDAO() {
        return propositionPresentationDAO;
    }

    @Override
    public void setDAO(PropositionPresentationDAO propositionPresentationDAO) {
        this.propositionPresentationDAO = propositionPresentationDAO;
    }

}
