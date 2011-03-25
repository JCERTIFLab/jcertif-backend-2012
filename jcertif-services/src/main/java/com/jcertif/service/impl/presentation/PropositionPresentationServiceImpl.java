/**
 * 
 */
package com.jcertif.service.impl.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcertif.bo.presentation.PropositionPresentation;
import com.jcertif.bo.presentation.StatutApprobation;
import com.jcertif.dao.api.presentation.PropositionPresentationDAO;
import com.jcertif.dao.api.presentation.StatutApprobationDAO;
import com.jcertif.service.AbstractService;
import com.jcertif.service.api.presentation.PropositionPresentationService;

/**
 * @author rossi
 *
 */
@Service
public class PropositionPresentationServiceImpl extends AbstractService<PropositionPresentation, Long, PropositionPresentationDAO> implements PropositionPresentationService {

    private static final String CODE_EN_TRAITEMENT = "T";

	@Autowired
    private PropositionPresentationDAO propositionPresentationDAO;
    
    @Autowired
    private StatutApprobationDAO stDao;

    @Override
    public PropositionPresentationDAO getDAO() {
        return propositionPresentationDAO;
    }

    @Override
    public void setDAO(PropositionPresentationDAO propositionPresentationDAO) {
        this.propositionPresentationDAO = propositionPresentationDAO;
    }

	/* (non-Javadoc)
	 * @see com.jcertif.service.AbstractService#save(java.lang.Object)
	 */
	@Override
	@Transactional
	public PropositionPresentation save(PropositionPresentation entite) {
		StatutApprobation statut = stDao.findByCode(CODE_EN_TRAITEMENT).iterator().next();
		entite.setStatutApprobation(statut);
		return propositionPresentationDAO.merge(entite);
	}
    
    

}
