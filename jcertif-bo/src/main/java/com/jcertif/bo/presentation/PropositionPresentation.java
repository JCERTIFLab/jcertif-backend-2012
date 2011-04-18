package com.jcertif.bo.presentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.bo.AbstractBO;
import com.jcertif.bo.comite.ComiteRevisionPresentation;
import com.jcertif.bo.conference.Conference;
import com.jcertif.bo.participant.Participant;

/**
 * Bo {@link PropositionPresentation}.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
@XmlRootElement
public class PropositionPresentation extends AbstractBO {

	private static final long serialVersionUID = 1L;

	/**
	 * Identifiant d'une présentation.
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Le titre de la présentation.
	 */
	@Column
	private String titre;

	/**
	 * La description de la présentation.
	 */
	@Column(length = 1000)
	private String description;

	/**
	 * Les détails de la présentation.
	 */
	@Column
	private String details;

	/**
	 * Un sommaire.
	 */
	@Column
	private String sommaire;

	/**
	 * Les besoins spécifiques.
	 */
	@Column
	private String besoinsSpecifiques;

	/**
	 * Mot clé de la présentation.
	 */
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "mot_cle_id")
	private MotCle motCle;

	/**
	 * Conférence d'une présentation.
	 */
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "conference_id")
	private Conference conference;

	/**
	 * Statut de l'approbation de la présentation.
	 */
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "statut_approbation_id")
	private StatutApprobation statutApprobation;

	/**
	 * Liste des sujets de la présentation.
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "proposition_presentation_sujet", joinColumns = @JoinColumn(name = "proposition_presentation_id"), inverseJoinColumns = @JoinColumn(name = "sujet_id"))
	private List<Sujet> sujetsInternal;

	/**
	 * Liste appréciations.
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "appreciation_presentation", joinColumns = @JoinColumn(name = "proposition_presentation_id"), inverseJoinColumns = @JoinColumn(name = "appreciation_id"))
	private List<Appreciation> appreciationsInternal;

	/**
	 * Liste comité révision présentation.
	 */
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "presentation_id")
	private Set<ComiteRevisionPresentation> comiteRevisionPresentationsInternal;

	/**
	 * Liste des auteurs.
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "propos_presentation_auteur", joinColumns = @JoinColumn(name = "presentation_id"), inverseJoinColumns = @JoinColumn(name = "auteur_id"))
	private Set<Participant> participants;

	/**
	 * @return l'identifiant d'une présentation
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Définit l'identifiant.
	 * 
	 * @param id
	 *            un identifiant
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return le titre.
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * Définit un titre.
	 * 
	 * @param titre
	 *            un titre
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return la description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Définit une description.
	 * 
	 * @param description
	 *            une description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return les détails
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * Définit les détails d'une présentation.
	 * 
	 * @param details
	 *            des détails
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the sommaire
	 */
	public String getSommaire() {
		return sommaire;
	}

	/**
	 * @param sommaire
	 *            the sommaire to set
	 */
	public void setSommaire(String sommaire) {
		this.sommaire = sommaire;
	}

	/**
	 * @return the besoinsSpecifiques
	 */
	public String getBesoinsSpecifiques() {
		return besoinsSpecifiques;
	}

	/**
	 * @param besoinsSpecifiques
	 *            the besoinsSpecifiques to set
	 */
	public void setBesoinsSpecifiques(String besoinsSpecifiques) {
		this.besoinsSpecifiques = besoinsSpecifiques;
	}

	/**
	 * @return le mot clé de la présentation
	 */
	public MotCle getMotCle() {
		return motCle;
	}

	/**
	 * Définit le mot clé de la présentation.
	 * 
	 * @param motCle
	 *            un mot clé
	 */
	public void setMotCle(MotCle motCle) {
		this.motCle = motCle;
	}

	/**
	 * @return le statut d'approbation
	 */
	public StatutApprobation getStatutApprobation() {
		return statutApprobation;
	}

	/**
	 * @return la conférence de la présentation
	 */
	public Conference getConference() {
		return conference;
	}

	/**
	 * Définit la conférence de la présentation.
	 * 
	 * @param conference
	 *            une conférence
	 */
	public void setConference(Conference conference) {
		this.conference = conference;
	}

	/**
	 * Définit un statut d'approbation.
	 * 
	 * @param statutApprobation
	 *            un statut d'approbation
	 */
	public void setStatutApprobation(StatutApprobation statutApprobation) {
		this.statutApprobation = statutApprobation;
	}

	/**
	 * @return la liste de sujets.
	 */
	public List<Sujet> getSujetsInternal() {
		if (sujetsInternal == null) {
			sujetsInternal = new ArrayList<Sujet>();
		}
		return sujetsInternal;
	}

	/**
	 * Définit une liste de sujet.
	 * 
	 * @param sujetsInternal
	 *            une liste de sujet
	 */
	public void setSujetsInternal(List<Sujet> sujetsInternal) {
		this.sujetsInternal = sujetsInternal;
	}

	/**
	 * @return la liste non modifiable de sujets.
	 */
	public List<Sujet> getSujets() {
		return Collections.unmodifiableList(this.getSujetsInternal());
	}

	/**
	 * Ajoute un sujet.
	 * 
	 * @param sujet
	 *            un sujet
	 * @return le résultat de l'ajout
	 */
	public boolean addSujet(final Sujet sujet) {
		return this.getSujetsInternal().add(sujet);
	}

	/**
	 * Supprimes un sujet.
	 * 
	 * @param sujet
	 *            un sujet
	 * @return le résultat de la suppression
	 */
	public boolean removeSujet(final Sujet sujet) {
		return this.getSujetsInternal().remove(sujet);
	}

	/**
	 * @return la liste d'appréciation
	 */
	protected List<Appreciation> getAppreciationsInternal() {
		if (appreciationsInternal == null) {
			appreciationsInternal = new ArrayList<Appreciation>();
		}
		return appreciationsInternal;
	}

	/**
	 * Définit la liste d'appréciation.
	 * 
	 * @param appreciationsInternal
	 *            une liste d'appréciation
	 */
	protected void setAppreciationsInternal(List<Appreciation> appreciationsInternal) {
		this.appreciationsInternal = appreciationsInternal;
	}

	/**
	 * @return la liste d'appréciation non modifiable
	 */
	public List<Appreciation> getAppreciations() {
		return Collections.unmodifiableList(getAppreciationsInternal());
	}

	/**
	 * Ajoute une appréciation.
	 * 
	 * @param appreciation
	 *            une appréciation
	 * @return le résultat de l'ajout d'une appréciation.
	 */
	public boolean addAppreciation(final Appreciation appreciation) {
		return getAppreciationsInternal().add(appreciation);
	}

	/**
	 * Supprime une appréciation.
	 * 
	 * @param appreciation
	 *            une appréciation
	 * @return le résultat de la suppression d'une appréciation.
	 */
	public boolean removeAppreciation(final Appreciation appreciation) {
		return getAppreciationsInternal().remove(appreciation);
	}

	/**
	 * @return the comiteRevisionPresentationsInternal
	 */
	protected Set<ComiteRevisionPresentation> getComiteRevisionPresentationsInternal() {
		return comiteRevisionPresentationsInternal;
	}

	/**
	 * @param comiteRevisionPresentationsInternal
	 *            the comiteRevisionPresentationsInternal to set
	 */
	protected void setComiteRevisionPresentationsInternal(
			Set<ComiteRevisionPresentation> comiteRevisionPresentationsInternal) {
		this.comiteRevisionPresentationsInternal = comiteRevisionPresentationsInternal;
	}

	/**
	 * Ajoute un comité de révision.
	 * 
	 * @param comite
	 *            un comité de révision
	 * @return le résultat de la suppression.
	 */
	public boolean addComiteRevisionPresentation(ComiteRevisionPresentation comite) {
		return getComiteRevisionPresentationsInternal().add(comite);
	}

	/**
	 * Supprime un comité de révision.
	 * 
	 * @param comite
	 * @return le résultat de la suppression
	 */
	public boolean removeComiteRevisionPresentation(ComiteRevisionPresentation comite) {
		return getComiteRevisionPresentationsInternal().remove(comite);
	}

	/**
	 * @return the participants
	 */
	public Set<Participant> getParticipants() {
		return participants;
	}

	/**
	 * @param participants
	 *            the participants to set
	 */
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(titre).append(description).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PropositionPresentation)) {
			return false;
		}

		final PropositionPresentation other = (PropositionPresentation) obj;

		return new EqualsBuilder().append(titre, other.getTitre())
				.append(description, other.getDescription()).isEquals();
	}

}
