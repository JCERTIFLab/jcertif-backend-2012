package com.jcertif.bo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * BO Salle.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
public class Salle {

	/**
	 * Identifiant d'une salle.
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Libelle d'une salle.
	 */
	@Column
	private String libelle;

	/**
	 * Description d'une salle.
	 */
	@Column
	private String description;

	/**
	 * Nombre de place d'une salle.
	 */
	@Column
	private Integer nombrePlace;

	/**
	 * Détails d'une salle.
	 */
	@Column
	private String details;

	/**
	 * Centre de conférence auquel appartient la salle.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "centre_conference_id")
	private CentreConference centreConference;

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
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the nombrePlace
	 */
	public Integer getNombrePlace() {
		return nombrePlace;
	}

	/**
	 * @param nombrePlace
	 *            the nombrePlace to set
	 */
	public void setNombrePlace(Integer nombrePlace) {
		this.nombrePlace = nombrePlace;
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
	 * @return the centreConference
	 */
	public CentreConference getCentreConference() {
		return centreConference;
	}

	/**
	 * @param centreConference
	 *            the centreConference to set
	 */
	public void setCentreConference(CentreConference centreConference) {
		this.centreConference = centreConference;
	}

}
