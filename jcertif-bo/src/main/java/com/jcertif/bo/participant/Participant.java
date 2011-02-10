package com.jcertif.bo.participant;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.bo.Person;
import com.jcertif.bo.cedule.CeduleParticipant;
import com.jcertif.bo.conference.Conference;
import com.jcertif.bo.presentation.PropositionPresentation;

/**
 * 
 * @author Douneg
 */
@Entity
@XmlRootElement
public class Participant extends Person {

    private static final long serialVersionUID = 1L;
    @Column
    private Calendar dateInscription;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "proposition_presentation_id")
    private PropositionPresentation presentationSoumise;
    @Column
    private String cvSoumis;
    @Column
    private String compagnie;
    @Column
    protected String codeParticipant;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_participant_id")
    private RoleParticipant roleparticipant;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "type_participant_id")
    private TypeParticipant typeParticipant;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "conference_id")
    private Conference conference;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "profil_utilisateur_id")
    private ProfilUtilisateur profilUtilisateur;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id")
    private Set<CeduleParticipant> ceduleparticipants = new HashSet<CeduleParticipant>();


    /**
     * Constructor
     */
    public Participant() {
        super();
    }

    /**
     * Constructor
     */
    public Participant(Long id, Calendar dateinscription, String salutation,
            String specialite, String prenom, String nom, Character sexe,
            String email, PropositionPresentation presentationsoumise,
            String cvsoumis, String details, RoleParticipant roleparticipant,
            Conference conference, Set<CeduleParticipant> ceduleparticipants) {
        super();
        this.setId(id);
        this.dateInscription = dateinscription;
        this.setSalutation(salutation);
        this.setSpecialite(specialite);
        this.setPrenom(prenom);
        this.setNom(nom);
        this.setSexe(sexe);
        this.setEmail(email);
        this.presentationSoumise = presentationsoumise;
        this.cvSoumis = cvsoumis;
        this.setDetails(details);
        this.roleparticipant = roleparticipant;
        this.conference = conference;
        this.ceduleparticipants = ceduleparticipants;
    }

    /**
     * Creates this.
     *
     * @param id
     * @param dateinscription
     * @param salutation
     * @param prenom
     * @param nom
     * @param sexe
     * @param email
     * @param telephone
     * @param presentationsoumise
     * @param cvsoumis
     * @param details
     */
    public Participant(Long id, String salutation,
            String prenom, String nom, Character sexe_MF, String email, PropositionPresentation presentationsoumise, String cvsoumis,
            String details) {
        super();
        this.setId(id);
        this.setSalutation(salutation);
        this.setPrenom(prenom);
        this.setNom(nom);
        this.setSexe(sexe_MF);
        this.setEmail(email);
        this.presentationSoumise = presentationsoumise;
        this.cvSoumis = cvsoumis;
        this.setDetails(details);
    }

    /**
     * @return the profilUtilisateur
     */
    public ProfilUtilisateur getProfilUtilisateur() {
        return profilUtilisateur;
    }

    /**
     * @param profilUtilisateur the profilUtilisateur to set
     */
    public void setProfilUtilisateur(ProfilUtilisateur profilUtilisateur) {
        this.profilUtilisateur = profilUtilisateur;
    }

    /**
     * @return the dateInscription
     */
    public Calendar getDateInscription() {
        return dateInscription;
    }

    /**
     * @param dateInscription the dateInscription to set
     */
    public void setDateInscription(Calendar dateInscription) {
        this.dateInscription = dateInscription;
    }

    /**
     * @return the presentationSoumise
     */
    public PropositionPresentation getPresentationSoumise() {
        return presentationSoumise;
    }

    /**
     * @param presentationSoumise the presentationSoumise to set
     */
    public void setPresentationSoumise(PropositionPresentation presentationSoumise) {
        this.presentationSoumise = presentationSoumise;
    }

    /**
     * @return the cvSoumis
     */
    public String getCvSoumis() {
        return cvSoumis;
    }

    /**
     * @param cvSoumis the cvSoumis to set
     */
    public void setCvSoumis(String cvSoumis) {
        this.cvSoumis = cvSoumis;
    }

    /**
     * @return the roleparticipantTODO
     */
    public RoleParticipant getRoleparticipant() {
        return roleparticipant;
    }

    /**
     * @param roleparticipant
     *            the roleparticipant to setTODOroleparticipant
     */
    public void setRoleparticipant(RoleParticipant roleparticipant) {
        this.roleparticipant = roleparticipant;
    }

    /**
     * @return the typeParticipant
     */
    public TypeParticipant getTypeParticipant() {
        return typeParticipant;
    }

    /**
     * @param typeParticipant the typeParticipant to set
     */
    public void setTypeParticipant(TypeParticipant typeParticipant) {
        this.typeParticipant = typeParticipant;
    }

    /**
     * @return the conferenceTODO
     */
    public Conference getConference() {
        return conference;
    }

    /**
     * @param conference
     *            the conference to setTODOconference
     */
    public void setConference(Conference conference) {
        this.conference = conference;
    }

    /**
     * @return the ceduleparticipantsTODO
     */
    public Set<CeduleParticipant> getCeduleparticipants() {
        return ceduleparticipants;
    }

    /**
     * @param ceduleparticipants
     *            the ceduleparticipants to setTODOceduleparticipants
     */
    public void setCeduleparticipants(Set<CeduleParticipant> ceduleparticipants) {
        this.ceduleparticipants = ceduleparticipants;
    }

    /**
     * @return the compagnie
     */
    public String getCompagnie() {
        return compagnie;
    }

    /**
     * @param compagnie the compagnie to set
     */
    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }

    /**
     * Get the value of codeParticipant
     *
     * @return the value of codeParticipant
     */
    public String getCodeParticipant() {
        return codeParticipant;
    }

    /**
     * Set the value of codeParticipant
     *
     * @param codeParticipant new value of codeParticipant
     */
    public void setCodeParticipant(String codeParticipant) {
        this.codeParticipant = codeParticipant;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getId()).append(this.getPrenom()).toHashCode();
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Participant)) {
            return false;
        }

        final Participant other = (Participant) obj;

        return new EqualsBuilder().append(this.getId(), other.getId()).append(this.getPrenom(), other.getPrenom()).isEquals();
    }
}
