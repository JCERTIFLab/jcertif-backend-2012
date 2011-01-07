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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * BO Auteur.
 * 
 * @author rossi.oddet
 */
@Entity
public class Auteur {

	/**
	 * Identifiant d'un auteur.
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Salutation.
	 */
	@Column
	private String salutation;

	/**
	 * Prénom de l'auteur.
	 */
	@Column
	private String prenom;

	/**
	 * Nom de l'auteur.
	 */
	@Column
	private String nom;

	/**
	 * Sexe de l'auteur.
	 */
	@Column(name = "sexe_MF")
	private Character sexe;

	/**
	 * Email.
	 */
	@Column
	private String email;

	/**
	 * Téléphone de l'auteur.
	 */
	@Column
	private String telephone;

	/**
	 * Spécialité de l'auteur.
	 */
	@Column
	private String specialite;

	/**
	 * Adresse de l'auteur.
	 */
	@Column
	private String adresse;

	/**
	 * Détails de l'auteur.
	 */
	@Column
	private String details;

	/**
	 * Liste de présentations.
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "presentation_auteur", joinColumns = @JoinColumn(name = "auteur_id"), inverseJoinColumns = @JoinColumn(name = "presentation_id"))
	private Set<Presentation> presentationsInternal;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the salutation
	 */
	public String getSalutation() {
		return salutation;
	}

	/**
	 * @param salutation
	 *            the salutation to set
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the sexe
	 */
	public Character getSexe() {
		return sexe;
	}

	/**
	 * @param sexe
	 *            the sexe to set
	 */
	public void setSexe(Character sexe) {
		this.sexe = sexe;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the specialite
	 */
	public String getSpecialite() {
		return specialite;
	}

	/**
	 * @param specialite
	 *            the specialite to set
	 */
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the presentationsInternal
	 */
	protected Set<Presentation> getPresentationsInternal() {
		if (presentationsInternal == null) {
			presentationsInternal = new HashSet<Presentation>();
		}
		return presentationsInternal;
	}

	/**
	 * @param presentationsInternal
	 *            the presentationsInternal to set
	 */
	protected void setPresentationsInternal(
			Set<Presentation> presentationsInternal) {
		this.presentationsInternal = presentationsInternal;
	}

	/**
	 * @return la liste des présentations de l'auteur.
	 */
	public Set<Presentation> getPresentations() {
		return Collections.unmodifiableSet(getPresentationsInternal());
	}

	/**
	 * Ajoute une présentation.
	 * 
	 * @param presentation
	 *            une présentation
	 * @return le résultat de l'ajout
	 */
	public boolean addPresentation(final Presentation presentation) {
		return getPresentationsInternal().add(presentation);
	}

	/**
	 * @param presentation
	 *            une présentation
	 * @return
	 */
	public boolean removePresentation(final Presentation presentation) {
		return getPresentationsInternal().remove(presentation);
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(email).toHashCode();
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

		return new EqualsBuilder().append(nom, other.getNom())
				.append(prenom, other.getPrenom())
				.append(email, other.getEmail()).isEquals();
	}

}
