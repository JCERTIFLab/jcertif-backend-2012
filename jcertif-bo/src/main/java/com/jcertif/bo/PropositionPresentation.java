package com.jcertif.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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

/**
 * Bo Présentation.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
@XmlRootElement
public class PropositionPresentation {

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
	@Column
	private String description;

	/**
	 * Les détails de la présentation.
	 */
	@Column
	private String details;

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
	private Set<Auteur> auteursInternal;

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
	protected List<Sujet> getSujetsInternal() {
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
	protected void setSujetsInternal(List<Sujet> sujetsInternal) {
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
	protected void setAppreciationsInternal(
			List<Appreciation> appreciationsInternal) {
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
	public boolean addComiteRevisionPresentation(
			ComiteRevisionPresentation comite) {
		return getComiteRevisionPresentationsInternal().add(comite);
	}

	/**
	 * Supprime un comité de révision.
	 * 
	 * @param comite
	 * @return le résultat de la suppression
	 */
	public boolean removeComiteRevisionPresentation(
			ComiteRevisionPresentation comite) {
		return getComiteRevisionPresentationsInternal().remove(comite);
	}

	/**
	 * @return the auteursInternal
	 */
	protected Set<Auteur> getAuteursInternal() {
		if (auteursInternal == null) {
			auteursInternal = new HashSet<Auteur>();
		}
		return auteursInternal;
	}

	/**
	 * @param auteursInternal
	 *            the auteursInternal to set
	 */
	protected void setAuteursInternal(Set<Auteur> auteursInternal) {
		this.auteursInternal = auteursInternal;
	}

	/**
	 * @return the auteursInternal
	 */
	public Set<Auteur> getAuteurs() {
		return auteursInternal;
	}

	/**
	 * Ajout d'un auteur.
	 * 
	 * @param auteur
	 *            un auteur
	 * @return le résultat de l'ajout
	 */
	public boolean addAuteur(final Auteur auteur) {
		return getAuteursInternal().add(auteur);
	}

	/**
	 * Suppression d'un auteur.
	 * 
	 * @param auteur
	 *            un auteur
	 * @return le résultat de la suppression
	 */
	public boolean removeAuteur(final Auteur auteur) {
		return getAuteursInternal().remove(auteur);
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(titre).append(description)
				.toHashCode();
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
