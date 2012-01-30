/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.facade.model.conference;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author rossi.oddet
 */
@XmlRootElement
public class Conference {

	private Long id;
	private String nom;
	private Calendar dateDebut;
	private Calendar dateFin;
	private String website;
	private String details;

	public Conference() {
		super();
	}

	public Conference(com.jcertif.bo.conference.Conference conf) {
		if (conf != null) {
			this.id = conf.getId();
			this.nom = conf.getNom();
			this.dateDebut = conf.getDateDebut();
			this.dateFin = conf.getDateFin();
			this.website = conf.getWebsite();
			this.details = conf.getDetails();
		}

	}

	public Calendar getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Calendar dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Calendar getDateFin() {
		return dateFin;
	}

	public void setDateFin(Calendar dateFin) {
		this.dateFin = dateFin;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
