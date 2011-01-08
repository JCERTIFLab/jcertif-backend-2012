package com.jcertif.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Un comité d'organisation.
 * 
 * @author rossi.oddet
 * 
 */
@Entity(name="Commite_organisation")
public class ComiteOrganisation {

	/**
	 * Identifiant d'un comité d'organisation.
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Le nom.
	 */
	@Column
	private String nom;

	/**
	 * Le prénom.
	 */
	@Column
	private String prenom;

	/**
	 * Le sexe.
	 */
	@Column
	private Character sexeMf;

	/**
	 * L'email.
	 */
	@Column
	private String email;

	/**
	 * Le téléphone.
	 */
	@Column
	private String telephone;

	/**
	 * Les détails.
	 */
	@Column
	private String details;

	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "commite_organisation_id")
	private Set<ComiteRevisionPresentation> comiteRevisionPresentationsInternal;

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
	 * @return the sexeMf
	 */
	public Character getSexeMf() {
		return sexeMf;
	}

	/**
	 * @param sexeMf
	 *            the sexeMf to set
	 */
	public void setSexeMf(Character sexeMf) {
		this.sexeMf = sexeMf;
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
	 * @return the comiteRevisionPresentationsInternal
	 */
	protected Set<ComiteRevisionPresentation> getComiteRevisionPresentationsInternal() {
		if (comiteRevisionPresentationsInternal == null) {
			comiteRevisionPresentationsInternal = new HashSet<ComiteRevisionPresentation>();
		}
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
	 * @return la liste des comités révision.
	 */
	public Set<ComiteRevisionPresentation> getComiteRevisionPresentations() {
		return comiteRevisionPresentationsInternal;
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
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(nom).append(prenom).append(email)
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

		if (!(obj instanceof ComiteOrganisation)) {
			return false;
		}

		final ComiteOrganisation other = (ComiteOrganisation) obj;

		return new EqualsBuilder().append(nom, other.getNom())
				.append(prenom, other.getPrenom())
				.append(email, other.getEmail()).isEquals();
	}

}
