/**
 * 
 */
package com.jcertif.service.participant;

import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.ProfilUtilisateur;
import com.jcertif.dao.api.participant.ProfilUtilisateurDAO;
import com.jcertif.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation of the {@link ParticipantService}.
 * @author Douneg
 *
 */
@Service
public class ProfilUtilisateurServiceImpl extends AbstractService<ProfilUtilisateur, Long, ProfilUtilisateurDAO> implements ProfilUtilisateurService {

    @Autowired
    private ProfilUtilisateurDAO profilUtilisateurDAO;

    @Override
    public ProfilUtilisateurDAO getDAO() {
        return profilUtilisateurDAO;
    }

    @Override
    public void setDAO(ProfilUtilisateurDAO profilUtilisateurDAO) {
        this.profilUtilisateurDAO = profilUtilisateurDAO;
    }
}
