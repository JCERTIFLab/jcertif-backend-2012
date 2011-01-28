package com.jcertif.presentation.data.bo.presentation;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.presentation.data.bo.AbstractBO;
import com.jcertif.presentation.data.bo.comite.ComiteRevisionPresentation;
import com.jcertif.presentation.data.bo.conference.Conference;



/**
 * Bo {@link PropositionPresentation}.
 * 
 * @author rossi.oddet
 * 
 */

@XmlRootElement
public class PropositionPresentation extends AbstractBO{

	private static final long serialVersionUID = 1L;

	/**
	 * Identifiant d'une pr�sentation.
	 */
	
	private Long id;

	/**
	 * Le titre de la pr�sentation.
	 */

	private String titre;

	/**
	 * La description de la pr�sentation.
	 */

	private String description;

	/**
	 * Les d�tails de la pr�sentation.
	 */

	private String details;
	
	/**
	 * Un sommaire.
	 */

	private String sommaire;
	
	/**
	 * Les besoins sp�cifiques.
	 */
	
	private String besoinsSpecifiques;

	/**
	 * Mot cl� de la pr�sentation.
	 */

	private MotCle motCle;

	/**
	 * Conf�rence d'une pr�sentation.
	 */

	private Conference conference;

	/**
	 * Statut de l'approbation de la pr�sentation.
	 */

	private StatutApprobation statutApprobation;

	/**
	 * Liste des sujets de la pr�sentation.
	 */
	
	private List<Sujet> sujetsInternal;

	/**
	 * Liste appr�ciations.
	 */

	private List<Appreciation> appreciationsInternal;

	/**
	 * Liste comit� r�vision pr�sentation.
	 */
	
	private Set<ComiteRevisionPresentation> comiteRevisionPresentationsInternal;

	/**
	 * Liste des auteurs.
	 */
	
	private Set<Auteur> auteursInternal;

	/**
	 * @return l'identifiant d'une pr�sentation
	 */
	public Long getId() {
		return id;
	}

	/**
	 * D�finit l'identifiant.
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
	 * D�finit un titre.
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
	 * D�finit une description.
	 * 
	 * @param description
	 *            une description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return les d�tails
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * D�finit les d�tails d'une pr�sentation.
	 * 
	 * @param details
	 *            des d�tails
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
	 * @param sommaire the sommaire to set
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
	 * @param besoinsSpecifiques the besoinsSpecifiques to set
	 */
	public void setBesoinsSpecifiques(String besoinsSpecifiques) {
		this.besoinsSpecifiques = besoinsSpecifiques;
	}

	/**
	 * @return le mot cl� de la pr�sentation
	 */
	public MotCle getMotCle() {
		return motCle;
	}

	/**
	 * D�finit le mot cl� de la pr�sentation.
	 * 
	 * @param motCle
	 *            un mot cl�
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
	 * @return la conf�rence de la pr�sentation
	 */
	public Conference getConference() {
		return conference;
	}

	/**
	 * D�finit la conf�rence de la pr�sentation.
	 * 
	 * @param conference
	 *            une conf�rence
	 */
	public void setConference(Conference conference) {
		this.conference = conference;
	}

	/**
	 * D�finit un statut d'approbation.
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
	 * D�finit une liste de sujet.
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
	 * @return le r�sultat de l'ajout
	 */
	public boolean addSujet(final Sujet sujet) {
		return this.getSujetsInternal().add(sujet);
	}

	/**
	 * Supprimes un sujet.
	 * 
	 * @param sujet
	 *            un sujet
	 * @return le r�sultat de la suppression
	 */
	public boolean removeSujet(final Sujet sujet) {
		return this.getSujetsInternal().remove(sujet);
	}

	/**
	 * @return la liste d'appr�ciation
	 */
	protected List<Appreciation> getAppreciationsInternal() {
		if (appreciationsInternal == null) {
			appreciationsInternal = new ArrayList<Appreciation>();
		}
		return appreciationsInternal;
	}

	/**
	 * D�finit la liste d'appr�ciation.
	 * 
	 * @param appreciationsInternal
	 *            une liste d'appr�ciation
	 */
	protected void setAppreciationsInternal(
			List<Appreciation> appreciationsInternal) {
		this.appreciationsInternal = appreciationsInternal;
	}

	/**
	 * @return la liste d'appr�ciation non modifiable
	 */
	public List<Appreciation> getAppreciations() {
		return Collections.unmodifiableList(getAppreciationsInternal());
	}

	/**
	 * Ajoute une appr�ciation.
	 * 
	 * @param appreciation
	 *            une appr�ciation
	 * @return le r�sultat de l'ajout d'une appr�ciation.
	 */
	public boolean addAppreciation(final Appreciation appreciation) {
		return getAppreciationsInternal().add(appreciation);
	}

	/**
	 * Supprime une appr�ciation.
	 * 
	 * @param appreciation
	 *            une appr�ciation
	 * @return le r�sultat de la suppression d'une appr�ciation.
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
	 * Ajoute un comit� de r�vision.
	 * 
	 * @param comite
	 *            un comit� de r�vision
	 * @return le r�sultat de la suppression.
	 */
	public boolean addComiteRevisionPresentation(
			ComiteRevisionPresentation comite) {
		return getComiteRevisionPresentationsInternal().add(comite);
	}

	/**
	 * Supprime un comit� de r�vision.
	 * 
	 * @param comite
	 * @return le r�sultat de la suppression
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
	 * @return le r�sultat de l'ajout
	 */
	public boolean addAuteur(final Auteur auteur) {
		return getAuteursInternal().add(auteur);
	}

	/**
	 * Suppression d'un auteur.
	 * 
	 * @param auteur
	 *            un auteur
	 * @return le r�sultat de la suppression
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
