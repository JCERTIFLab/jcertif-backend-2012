/**
 * 
 */
package com.jcertif.service.impl.participant;

import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.ProfilUtilisateur;
import com.jcertif.dao.api.participant.ProfilUtilisateurDAO;
import com.jcertif.service.AbstractService;
import com.jcertif.service.api.participant.ProfilUtilisateurService;
import com.jcertif.service.participant.ParticipantService;

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
