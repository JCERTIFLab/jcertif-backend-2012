package com.jcertif.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 
 * @author Mamadou
 * 
 */
@Entity
@XmlRootElement
public class CentreConference {

	/**
	 * Identifiant du Sujet.
	 */
	@Id
	@GeneratedValue
	@Column
	private Long id;

	/**
	 * Nom du centre conf�rence.
	 */
	@Column(name="nom1")
	private String nom;
	
	/**
	 * Description.
	 */
	@Column
	private String description;
	
	/**
	 * Adresse.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "Adresse_id")
	private Adresse adresse;
	
	/**
	 * T�l�phone.
	 */
	@Column
	private String telephone;
	
	/**
	 * Email.
	 */
	@Column
	private String email;
	
	/**
	 * Site web.
	 */
	@Column
	private String website;
	
	/**
	 * Nom contact.
	 */
	@Column
	private String nomContact;
	
	
	/**
	 * Pr�nom contact.
	 */
	@Column
	private String prenomContact;
	
	/**
	 * T�l�phone contact.
	 */
	@Column
	private String telephoneContact;
	
	
	/**
	 * Email contact.
	 */
	@Column
	private String emailContact;
	
	
	/**
	 * D�tails.
	 */
	@Column
	private String details;
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "centre_conference_id")
	private Set<Salle> centreConferenceSalle = new HashSet<Salle>();

	

	/**
	 * 
	 * @param id
	 * @param nom1
	 * @param description
	 * @param adresse
	 * @param email
	 * @param website
	 * @param nomContact
	 * @param prenomContact
	 * @param telephoneContact
	 * @param details
	 */
	public CentreConference(Long id, String nom, String description,
			Adresse adresse, String email, String website, String nomContact,
			String prenomContact, String telephoneContact, String details) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.adresse = adresse;
		this.email = email;
		this.website = website;
		this.nomContact = nomContact;
		this.prenomContact = prenomContact;
		this.telephoneContact = telephoneContact;
		this.details = details;
	}


	public CentreConference() {
		super();
	}


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
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom1 the nom1 to set
	 */
	public void setNom(String nom1) {
		this.nom = nom1;
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
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}


	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	 * @return the emailContact
	 */
	public String getEmailContact() {
		return emailContact;
	}


	/**
	 * @param emailContact the emailContact to set
	 */
	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}


	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	
	

	public Set<Salle> getCentreConferenceSalle() {
		return centreConferenceSalle;
	}


	public void setCentreConferenceSalle(Set<Salle> centreConferenceSalle) {
		this.centreConferenceSalle = centreConferenceSalle;
	}


	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(nom)
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

		if (!(obj instanceof CentreConference)) {
			return false;
		}

		final CentreConference other = (CentreConference)obj;

		return new EqualsBuilder().append(id, other.getId()).append(nom, other.getNom()).isEquals();
	}

}
