package com.jcertif.bo;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * BO CeduleSalle.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
public class CeduleSalle {

	/**
	 * Identifiant d'un cedule salle.
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Date cedule.
	 */
	@Column
	private Calendar dateCedule;

	/**
	 * Détails cedule salle.
	 */
	@Column
	private String details;

	/**
	 * Salle cedulle salle.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "salle_id")
	private Salle salle;

	/**
	 * Staut cedulle salle.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "statut_cedule_id")
	private StatutCedule statutCedule;

	/**
	 * Conférence d'une cedule Salle.
	 */
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "conference_id")
	private Conference conference;


	/**
	 * Un constructeur.
	 */
	public CeduleSalle() {
		super();
	}

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
	 * @return the dateCedule
	 */
	public Calendar getDateCedule() {
		return dateCedule;
	}

	/**
	 * @param dateCedule
	 *            the dateCedule to set
	 */
	public void setDateCedule(Calendar dateCedule) {
		this.dateCedule = dateCedule;
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
	 * @return the salle
	 */
	public Salle getSalle() {
		return salle;
	}

	/**
	 * @param salle
	 *            the salle to set
	 */
	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	/**
	 * @return the statutCedule
	 */
	public StatutCedule getStatutCedule() {
		return statutCedule;
	}

	/**
	 * @param statutCedule
	 *            the statutCedule to set
	 */
	public void setStatutCedule(StatutCedule statutCedule) {
		this.statutCedule = statutCedule;
	}

	/**
	 * @return the conference
	 */
	public Conference getConference() {
		return conference;
	}

	/**
	 * @param conference the conference to set
	 */
	public void setConference(Conference conference) {
		this.conference = conference;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CeduleSalle)) {
			return false;
		}

		final CeduleSalle other = (CeduleSalle) obj;

		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}
