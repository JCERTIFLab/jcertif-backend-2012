/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.bo;

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

/**
 * @author chrisbel
 */
@Entity
public class Conference {

	
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;
	@Column
	private Calendar datedebut;
	@Column
	private Calendar date_fin;
	@Column
	private String website;
	@Column
	private String details;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "organisateur_conference", joinColumns = @JoinColumn(name = "conference_id"), inverseJoinColumns = @JoinColumn(name = "organisateur_id"))
	private Set<Organisateur> organisateurs = new HashSet<Organisateur>();

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

	public Calendar getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Calendar date_fin) {
		this.date_fin = date_fin;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	
	
	public Set<Organisateur> getOrganisateurs() {
		return organisateurs;
	}

	public void setOrganisateurs(Set<Organisateur> organisateurs) {
		this.organisateurs = organisateurs;
	}

	/**
	 * @return the datedebutTODO
	 */
	public Calendar getDatedebut() {
		return datedebut;
	}

	/**
	 * @param datedebut the datedebut to setTODOdatedebut
	 */
	public void setDatedebut(Calendar datedebut) {
		this.datedebut = datedebut;
	}

	

}
