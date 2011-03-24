/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.bo.conference;

import java.util.Calendar;
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
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.bo.AbstractBO;

/**
 * @author chrisbel
 */
@Entity
@XmlRootElement
public class Conference extends AbstractBO {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "name")
	private String nom;
	@Column
	private Calendar dateDebut;
	@Column
	private Calendar dateFin;
	@Column
	private String website;
	@Column
	private String details;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "organisateur_conference", joinColumns = @JoinColumn(name = "conference_id"), inverseJoinColumns = @JoinColumn(name = "organisateur_id"))
	private Set<Organisateur> organisateurs = new HashSet<Organisateur>();
	
	@OneToMany
	@JoinColumn(name = "conference_id")
	private Set<Faq> faqs = new HashSet<Faq>();

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
	 * @return the faqs
	 */
	public Set<Faq> getFaqs() {
		return faqs;
	}

	/**
	 * @param faqs the faqs to set
	 */
	public void setFaqs(Set<Faq> faqs) {
		this.faqs = faqs;
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
