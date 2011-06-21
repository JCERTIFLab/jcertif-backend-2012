package com.jcertif.facade.model.evenement;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.presentation.Sujet;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *  BO Facade Event.
 * @author rossi.oddet
 */
@XmlRootElement
public class Event {
    public static final String SEPARATOR = ",";

    private Long id;
    private String nom;
    private Calendar dateDebut;
    private Calendar dateFin;
    private String salle;
    private String sommaire;
    private String description;
    private String speakersId;
    private String motCle;
    private String sujets;

    /**
     * Default constructor.
     */
    public Event() {
        super();
    }

    /**
     * A constructor.
     * @param evenement 
     */
    public Event(Evenement evenement) {
        this.id = evenement.getId();
        this.nom = evenement.getNomEvenement();
        this.dateDebut = evenement.getDateDebutPrevue();
        this.dateFin = evenement.getDateFinPrevue();
        updateSalle(evenement);
        updateSommaire(evenement);
        updateDescription(evenement);
        updateSpeakersId(evenement);
        updateMotCle(evenement);
        updateSujets(evenement);
    }

    private void updateSalle(Evenement evenement) {
        if (evenement.getCeduleSalles() != null && !evenement.getCeduleSalles().isEmpty()) {
            this.salle = evenement.getCeduleSalles().iterator().next().getSalle().getLibelle();
        }
    }

    private void updateDescription(Evenement evenement) {
        if (evenement.getPropositionPresentation() != null) {
            this.description = evenement.getPropositionPresentation().getDescription();
        }
    }

    private void updateSpeakersId(Evenement evenement) {
        if (evenement.getPropositionPresentation() != null && evenement.getPropositionPresentation().getParticipants() != null) {
            for (Participant participant : evenement.getPropositionPresentation().getParticipants()) {
                if(this.speakersId != null){
                    this.speakersId += SEPARATOR + participant.getId();
                } else {
                    this.speakersId = String.valueOf(participant.getId());
                }
            }
        }
    }

    private void updateMotCle(Evenement evenement) {
        if(evenement.getPropositionPresentation() != null && evenement.getPropositionPresentation().getMotCle() != null){
            this.motCle = evenement.getPropositionPresentation().getMotCle().getMotCle();
        }
    }

    private void updateSujets(Evenement evenement) {
        if (evenement.getPropositionPresentation() != null && evenement.getPropositionPresentation().getSujets() != null) {
            for (Sujet sujet : evenement.getPropositionPresentation().getSujets()) {
                if(this.sujets != null){
                    this.sujets += SEPARATOR + sujet.getLibelle();
                } else {
                    this.sujets = sujet.getLibelle();
                }
            }
        }
    }
    
    
    private void updateSommaire(Evenement evenement) {
       if(evenement.getPropositionPresentation() != null){
            this.sommaire = evenement.getPropositionPresentation().getSommaire();
        }
    }

    public Calendar getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Calendar dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Calendar getDateFin() {
        return dateFin;
    }

    public void setDateFin(Calendar dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getSommaire() {
        return sommaire;
    }

    public void setSommaire(String sommaire) {
        this.sommaire = sommaire;
    }

    public String getSpeakersId() {
        return speakersId;
    }

    public void setSpeakersId(String speakersId) {
        this.speakersId = speakersId;
    }

    public String getSujets() {
        return sujets;
    }

    public void setSujets(String sujets) {
        this.sujets = sujets;
    }

}
