package com.jcertif.bo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * BO Organisateur centre Conf.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
@XmlRootElement
public class OrganisateurCentreConf extends Person {

	private static final long serialVersionUID = 1L;

	@Column
	private String website;

	/**
	 * Mot clé de la présentation.
	 */
	/**
	 * Liste comité révision présentation.
	 */
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "organisateur_centre_conf_id")
	private Set<Conference> conferencesInternal;

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website
	 *            the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the conferencesInternal
	 */
	protected Set<Conference> getConferencesInternal() {
		return conferencesInternal;
	}

	/**
	 * @param conferencesInternal
	 *            the conferencesInternal to set
	 */
	protected void setConferencesInternal(Set<Conference> conferencesInternal) {
		this.conferencesInternal = conferencesInternal;
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

		if (!(obj instanceof OrganisateurCentreConf)) {
			return false;
		}

		final OrganisateurCentreConf other = (OrganisateurCentreConf) obj;

		return new EqualsBuilder().append(this.getNom(), other.getNom())
				.append(this.getPrenom(), other.getPrenom())
				.append(this.getEmail(), other.getEmail()).isEquals();
	}

}
