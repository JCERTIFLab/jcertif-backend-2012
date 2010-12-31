package com.jcertif.bo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private Date dateCedule;

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
	
	//TODO Ajouter le BO conférence quand il sera prêt.


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
	 * @return the dateCedule
	 */
	public Date getDateCedule() {
		return dateCedule;
	}


	/**
	 * @param dateCedule the dateCedule to set
	 */
	public void setDateCedule(Date dateCedule) {
		this.dateCedule = dateCedule;
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


	/**
	 * @return the salle
	 */
	public Salle getSalle() {
		return salle;
	}


	/**
	 * @param salle the salle to set
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
	 * @param statutCedule the statutCedule to set
	 */
	public void setStatutCedule(StatutCedule statutCedule) {
		this.statutCedule = statutCedule;
	}
	
	
	
	

}
