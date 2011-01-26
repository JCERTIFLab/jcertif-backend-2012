package com.jcertif.presentation.data.bo.presentation;



import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.presentation.data.bo.Person;



/**
 * BO Auteur.
 * 
 * @author rossi.oddet
 */

@XmlRootElement
public class Auteur extends Person {

	private static final long serialVersionUID = 1L;

	private String biographieSommaire;
	
	private String photo;

	
	/**
	 * @return the biographieSommaire
	 */
	public String getBiographieSommaire() {
		return biographieSommaire;
	}

	/**
	 * @param biographieSommaire the biographieSommaire to set
	 */
	public void setBiographieSommaire(String biographieSommaire) {
		this.biographieSommaire = biographieSommaire;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
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
	protected void setPresentationsInternal(
			Set<PropositionPresentation> presentationsInternal) {
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
	 * @see java.lang.Object#hashCode()
	 */
	 
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getEmail()).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	 
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Auteur)) {
			return false;
		}

		final Auteur other = (Auteur) obj;

		return new EqualsBuilder().append(this.getNom(), other.getNom())
				.append(this.getPrenom(), other.getPrenom())
				.append(this.getEmail(), other.getEmail()).isEquals();
	}

}
