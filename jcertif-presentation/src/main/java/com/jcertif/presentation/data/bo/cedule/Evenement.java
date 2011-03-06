package com.jcertif.presentation.data.bo.cedule;



import java.util.Calendar;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.presentation.data.bo.AbstractBO;

/**
 * 
 * @author Douneg
 */

@XmlRootElement
public class Evenement extends AbstractBO{

	private static final long serialVersionUID = 1L;

	private Long id;

	protected String nomEvenement;

	private Calendar dateDebutPrevue;

	private Calendar dateFinPrevue;

	private Calendar dateDebutEffective;

	private Calendar dateFinEffective;

	private String details;

	private TypeEvenement typeEvenement;
	
	private Set<CeduleSalle> ceduleSalles;
	
	private Set<CeduleParticipant> ceduleParticipants;

	/**
	 * @param id
	 * @param nom_evenement
	 * @param dateDebutPrevue
	 * @param datefinprevue
	 * @param dateDebutEffective
	 * @param dateFinEffective
	 * @param details
	 * 
	 */
	public Evenement(Long id, String nom_evenement, Calendar dateDebutPrevue,
			Calendar datefinprevue, Calendar dateDebutEffective,
			Calendar dateFinEffective, String details) {
		super();
		this.id = id;
		this.nomEvenement = nom_evenement;
		this.dateDebutPrevue = dateDebutPrevue;
		this.dateFinPrevue = datefinprevue;
		this.dateDebutEffective = dateDebutEffective;
		this.dateFinEffective = dateFinEffective;
		this.details = details;
	}

	/**
     *
     */
	public Evenement() {
		super();
	}

	/**
	 * Get the value of typeEvenement
	 * 
	 * @return the value of typeEvenement
	 */
	public TypeEvenement getTypeEvenement() {
		return typeEvenement;
	}

	/**
	 * Set the value of typeEvenement
	 * 
	 * @param details
	 *            new value of typeEvenement
	 */
	public void setTypeEvenement(TypeEvenement typeEvenement) {
		this.typeEvenement = typeEvenement;
	}

	/**
	 * @return the nomEvenement
	 */
	public String getNomEvenement() {
		return nomEvenement;
	}

	/**
	 * @param nomEvenement
	 *            the nomEvenement to set
	 */
	public void setNomEvenement(String nomEvenement) {
		this.nomEvenement = nomEvenement;
	}

	/**
	 * @return the dateDebutPrevue
	 */
	public Calendar getDateDebutPrevue() {
		return dateDebutPrevue;
	}

	/**
	 * @param dateDebutPrevue
	 *            the dateDebutPrevue to set
	 */
	public void setDateDebutPrevue(Calendar dateDebutPrevue) {
		this.dateDebutPrevue = dateDebutPrevue;
	}

	/**
	 * @return the dateFinPrevue
	 */
	public Calendar getDateFinPrevue() {
		return dateFinPrevue;
	}

	/**
	 * @param dateFinPrevue
	 *            the dateFinPrevue to set
	 */
	public void setDateFinPrevue(Calendar dateFinPrevue) {
		this.dateFinPrevue = dateFinPrevue;
	}

	/**
	 * @return the dateDebutEffective
	 */
	public Calendar getDateDebutEffective() {
		return dateDebutEffective;
	}

	/**
	 * @param dateDebutEffective
	 *            the dateDebutEffective to set
	 */
	public void setDateDebutEffective(Calendar dateDebutEffective) {
		this.dateDebutEffective = dateDebutEffective;
	}

	/**
	 * @return the dateFinEffective
	 */
	public Calendar getDateFinEffective() {
		return dateFinEffective;
	}

	/**
	 * @param dateFinEffective
	 *            the dateFinEffective to set
	 */
	public void setDateFinEffective(Calendar dateFinEffective) {
		this.dateFinEffective = dateFinEffective;
	}

	/**
	 * Get the value of details
	 * 
	 * @return the value of details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * Set the value of details
	 * 
	 * @param details
	 *            new value of details
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	



	/**
	 * @return the ceduleSalles
	 */
	public Set<CeduleSalle> getCeduleSalles() {
		return ceduleSalles;
	}

	/**
	 * @param ceduleSalles the ceduleSalles to set
	 */
	public void setCeduleSalles(Set<CeduleSalle> ceduleSalles) {
		this.ceduleSalles = ceduleSalles;
	}

	/**
	 * @return the ceduleParticipants
	 */
	public Set<CeduleParticipant> getCeduleParticipants() {
		return ceduleParticipants;
	}

	/**
	 * @param ceduleParticipants the ceduleParticipants to set
	 */
	public void setCeduleParticipants(Set<CeduleParticipant> ceduleParticipants) {
		this.ceduleParticipants = ceduleParticipants;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId())
				.append(this.getDetails()).append(this.getNomEvenement())
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

		if (!(obj instanceof Evenement)) {
			return false;
		}

		final Evenement other = (Evenement) obj;

		return new EqualsBuilder().append(this.getId(), other.getId())
				.append(this.getDetails(), other.getDetails())
				.append(this.getNomEvenement(), other.getNomEvenement())
				.isEquals();
	}
}
