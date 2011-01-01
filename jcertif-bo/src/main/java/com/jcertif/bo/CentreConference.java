package com.jcertif.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * 
 * @author Mamadou
 * 
 */
@Entity
public class CentreConference {

	/**
	 * Identifiant du Sujet.
	 */
	@Id
	@GeneratedValue
	@Column
	private Long id;

	@Column
	String nom1;
	@Column
	String description;
	@Column
	String adresse;
	@Column
	String email;
	@Column
	String website;
	@Column
	String nomContact;
	@Column
	String prenomContact;
	@Column
	String telephoneContact;
	@Column
	String Details;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nom1
	 */
	public String getNom1() {
		return nom1;
	}

	/**
	 * @param nom1 the nom1 to set
	 */
	public void setNom1(String nom1) {
		this.nom1 = nom1;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the nomContact
	 */
	public String getNomContact() {
		return nomContact;
	}

	/**
	 * @param nomContact the nomContact to set
	 */
	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}

	/**
	 * @return the prenomContact
	 */
	public String getPrenomContact() {
		return prenomContact;
	}

	/**
	 * @param prenomContact the prenomContact to set
	 */
	public void setPrenomContact(String prenomContact) {
		this.prenomContact = prenomContact;
	}

	/**
	 * @return the telephoneContact
	 */
	public String getTelephoneContact() {
		return telephoneContact;
	}

	/**
	 * @param telephoneContact the telephoneContact to set
	 */
	public void setTelephoneContact(String telephoneContact) {
		this.telephoneContact = telephoneContact;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return Details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		Details = details;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Sujet)) {
			return false;
		}

		final CentreConference other = (CentreConference) obj;

		return new EqualsBuilder().append(nom1, other.getNom1())
		.append(email, other.getEmail()).isEquals();
	}

}