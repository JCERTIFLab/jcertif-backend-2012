/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.bo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * BO Auteur.
 * 
 * @author rossi.oddet
 */
@Entity
@XmlRootElement
public class Auteur extends Person {

	private static final long serialVersionUID = 1L;
	@Column
	private String biographie_sommaire;
	@Column
	private String photo;

	/**
	 * @return the biographie_sommaire
	 */
	public String getBiographie_sommaire() {
		return biographie_sommaire;
	}

	/**
	 * @param biographie_sommaire the biographie_sommaire to set
	 */
	public void setBiographie_sommaire(String biographie_sommaire) {
		this.biographie_sommaire = biographie_sommaire;
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
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "propos_presentation_auteur", joinColumns = @JoinColumn(name = "auteur_id"), inverseJoinColumns = @JoinColumn(name = "presentation_id"))
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
