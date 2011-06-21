/**
 * 
 */
package com.jcertif.service.impl.cedule;

import com.jcertif.bo.cedule.CeduleParticipant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.presentation.PropositionPresentation;
import com.jcertif.dao.api.cedule.CeduleParticipantDAO;
import com.jcertif.dao.api.cedule.EvenementDAO;
import com.jcertif.dao.api.participant.ParticipantDAO;
import com.jcertif.service.AbstractService;
import com.jcertif.service.api.cedule.EvenementService;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;

/**
 * service de gestion des �v�nements
 * 
 * @author thierry.balla
 * 
 */
@Service
public class EvenementServiceImpl extends AbstractService<Evenement, Long, EvenementDAO> implements
        EvenementService {

    @Autowired
    private EvenementDAO evenementDAO;
    @Autowired
    private ParticipantDAO participantDAO;
    @Autowired
    private CeduleParticipantDAO ceduleParticipantDAO;

    @Override
    public EvenementDAO getDAO() {
        return evenementDAO;
    }

    @Override
    public void setDAO(EvenementDAO dao) {
        this.evenementDAO = dao;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jcertif.service.AbstractService#findAll()
     */
    @Override
    public List<Evenement> findAll() {
        List<Evenement> events = evenementDAO.findAll();

        if (events != null && !events.isEmpty()) {
            for (Evenement event : events) {
                PropositionPresentation propo = event.getPropositionPresentation();

                if (propo != null && propo.getParticipants() != null
                        && !propo.getParticipants().isEmpty()) {
                    propo.getParticipants().iterator().next();
                }
            }
        }
        return events;
    }

    @Override
    @Transactional
    public Set<Long> addUserToEvent(Long idEvent, String email) {
        Set<Participant> participantList = new HashSet<Participant>(participantDAO.findByEmail(email));
        Set<Long> idEvents = new HashSet<Long>();

        // Ces cas d'erreurs ne devraient fonctionnellement jamais arriv�s
        if (participantList.isEmpty()) {
            throw new RuntimeException("Adresse email non trouv�");
        }
        if (participantList.size() > 1) {
            throw new RuntimeException("Plusieurs adresses email existent en base");
        }

        Participant participant = participantList.iterator().next();

        CeduleParticipant cedule = new CeduleParticipant();
        cedule.setDateCedule(Calendar.getInstance());
        cedule.setEvenementId(idEvent);
        cedule.setParticipantId(participant.getId());


        List<CeduleParticipant> cedules = ceduleParticipantDAO.findAll();

        if (!cedules.contains(cedule)) {
            ceduleParticipantDAO.persist(cedule);
            idEvents.add(idEvent);
        }
        
        for (CeduleParticipant cedulePart : participant.getCeduleParticipants()) {
            idEvents.add(cedulePart.getEvenementId());
        }

        return idEvents;
    }
}
