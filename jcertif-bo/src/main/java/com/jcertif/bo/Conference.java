/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.bo;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
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

	@Column(name="name")
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
	 * @return the dateDebut
	 */
	public Calendar getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
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
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Calendar dateFin) {
		this.dateFin = dateFin;
	}

	public String toXML(){
		StringBuilder xml = new StringBuilder();
		xml.append("<conference>");
		xml.append("<id>").append(id).append("</id>");
		xml.append("<nom>").append(nom).append("</nom>");
		xml.append("<datedebut>").append(dateDebut).append("</datedebut>");
		xml.append("<datefin>").append(dateFin).append("</datefin>");
		xml.append("<website>").append(website).append("</website>");
		xml.append("<details>").append(details).append("</details>");
		xml.append("<organisateurs>");
		Iterator<Organisateur> iter = organisateurs.iterator();
		while(iter.hasNext()){
			Organisateur organisateur = iter.next();
			xml.append(organisateur.toXML());
		}
		xml.append("</organisateurs>");
		xml.append("<link>").append(getLink()).append("</link>");
		xml.append("</conference>");
		
		return xml.toString();
	}
	
	public String toJSON() {
		StringBuilder json = new StringBuilder();
		json.append("{\"conference\":{\"id\":\"").append(id)
		.append("\", \"nom\":\"").append(nom)
		.append("\", \"datedebut\":\"").append(dateDebut)
		.append("\", \"date_fin\":\"").append(dateFin)
		.append("\", \"website\":\"").append(website)
		.append("\", \"details\":\"").append(details)
		.append("\", \"organisateurs\":\"");
		Iterator<Organisateur> iter = organisateurs.iterator();
		while(iter.hasNext()){
			Organisateur organisateur = iter.next();
			json.append(organisateur.toJSON());
		}
		json.append("\", \"link\":\"").append(getLink()).append("\"}}");
		
		return json.toString();
	}

	private String getLink() {
		return "/conférence/" + nom;
	}

}
