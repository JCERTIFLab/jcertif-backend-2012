package com.jcertif.presentation.data.bo.participant;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.presentation.data.bo.Person;
import com.jcertif.presentation.data.bo.cedule.CeduleParticipant;
import com.jcertif.presentation.data.bo.conference.Conference;
import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;

/**
 * 
 * @author Douneg
 */
@XmlRootElement
public class Participant extends Person {

	private static final long serialVersionUID = 1L;
	private Calendar dateInscription;
	private String cvSoumis;
	private String compagnie;
	private RoleParticipant roleparticipant;
	private TypeParticipant typeParticipant;
	private Conference conference;
	/*
	 * code qui permet un participant apres son inscription de faire les taches
	 * de proposition de presentation d'effectuer un payement de son inscription
	 */
	private String codeParticipant;
	private ProfilUtilisateur profilUtilisateur;
	private Set<CeduleParticipant> ceduleParticipants;
	private Set<PropositionPresentation> propositionPresentations;

	/**
	 * Constructor
	 */
	public Participant() {
		super();
	}

	/**
	 * Constructor
	 */
	public Participant(Long id, Calendar dateinscription, String salutation, String specialite,
			String prenom, String nom, Character sexe, String email, String cvsoumis,
			String details, RoleParticipant roleparticipant, Conference conference,
			Set<CeduleParticipant> ceduleparticipants) {
		super();
		this.setId(id);
		this.dateInscription = dateinscription;
		this.setSalutation(salutation);
		this.setSpecialite(specialite);
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setSexe(sexe);
		this.setEmail(email);

		this.cvSoumis = cvsoumis;
		this.setDetails(details);
		this.roleparticipant = roleparticipant;
		this.conference = conference;
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
	public Participant(Long id, String salutation, String prenom, String nom, Character sexe_MF,
			String email, String cvsoumis, String details) {
		super();
		this.setId(id);
		this.setSalutation(salutation);
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setSexe(sexe_MF);
		this.setEmail(email);
		this.cvSoumis = cvsoumis;
		this.setDetails(details);
	}

	/**
	 * Liste de présentations.
	 */
	private Set<PropositionPresentation> presentationsInternal;

	/**
	 * @return the presentationsInternal
	 */
	protected Set<PropositionPresentation> getPresentationsInternal() {
		if (presentationsInternal == null) {
			presentationsInternal = new HashSet<PropositionPresentation>();
		}
		return presentationsInternal;
	}

	/**
	 * @param presentationsInternal
	 *            the presentationsInternal to set
	 */
	protected void setPresentationsInternal(Set<PropositionPresentation> presentationsInternal) {
		this.presentationsInternal = presentationsInternal;
	}

	/**
	 * @return la liste des présentations de l'auteur.
	 */
	public Set<PropositionPresentation> getPresentations() {
		return Collections.unmodifiableSet(getPresentationsInternal());
	}

	/**
	 * Ajoute une présentation.
	 * 
	 * @param presentation
	 *            une présentation
	 * @return le résultat de l'ajout
	 */
	public boolean addPresentation(final PropositionPresentation presentation) {
		return getPresentationsInternal().add(presentation);
	}

	/**
	 * @param presentation
	 *            une présentation
	 * @return
	 */
	public boolean removePresentation(final PropositionPresentation presentation) {
		return getPresentationsInternal().remove(presentation);
	}

	/**
	 * @return the profilUtilisateur
	 */
	public ProfilUtilisateur getProfilUtilisateur() {
		return profilUtilisateur;
	}

	/**
	 * @param profilUtilisateur
	 *            the profilUtilisateur to set
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
	 * @param dateInscription
	 *            the dateInscription to set
	 */
	public void setDateInscription(Calendar dateInscription) {
		this.dateInscription = dateInscription;
	}

	/**
	 * @return the cvSoumis
	 */
	public String getCvSoumis() {
		return cvSoumis;
	}

	/**
	 * @param cvSoumis
	 *            the cvSoumis to set
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
	 * @param typeParticipant
	 *            the typeParticipant to set
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
	 * @return the ceduleParticipants
	 */
	public Set<CeduleParticipant> getCeduleParticipants() {
		return ceduleParticipants;
	}

	/**
	 * @param ceduleParticipants
	 *            the ceduleParticipants to set
	 */
	public void setCeduleParticipants(Set<CeduleParticipant> ceduleParticipants) {
		this.ceduleParticipants = ceduleParticipants;
	}

	/**
	 * @return the compagnie
	 */
	public String getCompagnie() {
		return compagnie;
	}

	/**
	 * @return the codeparticipant
	 * 
	 */
	public String getCodeParticipant() {
		return codeParticipant;
	}

	/**
	 * @param codeparticipant
	 *            the codeparticipant to set codeparticipant
	 */
	public void setCodeParticipant(String codeParticipant) {
		this.codeParticipant = codeParticipant;
	}

	/**
	 * @param compagnie
	 *            the compagnie to set
	 */
	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}

	/**
	 * @return the propositionPresentations
	 */
	public Set<PropositionPresentation> getPropositionPresentations() {
		return propositionPresentations;
	}

	/**
	 * @param propositionPresentations
	 *            the propositionPresentations to set
	 */
	public void setPropositionPresentations(Set<PropositionPresentation> propositionPresentations) {
		this.propositionPresentations = propositionPresentations;
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

		return new EqualsBuilder().append(this.getId(), other.getId())
				.append(this.getPrenom(), other.getPrenom()).isEquals();
	}

}
