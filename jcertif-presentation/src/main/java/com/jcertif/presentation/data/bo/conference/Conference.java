package com.jcertif.presentation.data.bo.conference;



import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author chrisbel
 */
@XmlRootElement
public class Conference{

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nom;

	private Calendar dateDebut;

	private Calendar dateFin;

	private String website;

	private String details;
	
	private Set<Organisateur> organisateurs = new HashSet<Organisateur>();

	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * 
	 * @return website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * 
	 * @param website
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * 
	 * @return liste des organisateurs
	 */
	public Set<Organisateur> getOrganisateurs() {
		return organisateurs;
	}

	/**
	 * 
	 * @param organisateurs
	 */
	public void setOrganisateurs(Set<Organisateur> organisateurs) {
		this.organisateurs = organisateurs;
	}

	/**
	 * @return the dateDebut
	 */
	public Calendar getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut
	 *            the dateDebut to set
	 */
	public void setDateDebut(Calendar dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public Calendar getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin
	 *            the dateFin to set
	 */
	public void setDateFin(Calendar dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	 
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(nom).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	 
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Conference)) {
			return false;
		}

		final Conference other = (Conference) obj;

		return new EqualsBuilder().append(nom, other.getNom())
				.append(details, other.getDetails()).isEquals();
	}

}
