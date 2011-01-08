/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.bo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author Douneg
 * 
 */
@Entity
public class Organisateur extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "organisateur_conference", joinColumns = @JoinColumn(name = "organisateur_id"), inverseJoinColumns = @JoinColumn(name = "conference_id"))
	private Set<Conference> conferences=new HashSet<Conference>();
	
	/**
	 * Constructor
	 */
	public Organisateur() {
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * Constructor
	 */
	public Organisateur(Long id, String prenom, String nom, Character sexe_MF,
			String email, String telephone, String details,
			Set<Conference> conferences) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.sexe_MF = sexe_MF;
		this.email = email;
		this.telephone = telephone;
		this.details = details;
		this.conferences = conferences;
	}


	
	public Set<Conference> getConferences() {
		return conferences;
	}

	public void setConferences(Set<Conference> conferences) {
		this.conferences = conferences;
	}
	
	public String toXML(){
		StringBuilder xml = new StringBuilder();
		xml.append("<organisateur>");
		xml.append("<id>").append(id).append("</id>");
		xml.append("<prenom>").append(prenom).append("</prenom>");
		xml.append("<nom>").append(nom).append("</nom>");
		xml.append("<sexe>").append(sexe_MF).append("</sexe>");
		xml.append("<email>").append(email).append("</email>");
		xml.append("<telephone>").append(telephone).append("</telephone>");
		xml.append("<details>").append(details).append("</details>");
		xml.append("<conferences>");
		Iterator<Conference> iter = conferences.iterator();
		while(iter.hasNext()){
			Conference conference = iter.next();
			xml.append(conference.toXML());
		}
		xml.append("</conferences>");
		xml.append("<link>").append(getLink()).append("</link>");
		xml.append("</organisateur>");
		
		return xml.toString();
	}
	
	private String getLink() {
		return "/organisateur/" + nom;
	}
	
	public String toJSON() {
		StringBuilder json = new StringBuilder();
		json.append("{\"conference\":{\"id\":\"").append(id)
		.append("\", \"prenom\":\"").append(prenom)
		.append("\", \"nom\":\"").append(nom)
		.append("\", \"sexe\":\"").append(sexe_MF)
		.append("\", \"email\":\"").append(email)
		.append("\", \"telephone\":\"").append(telephone)
		.append("\", \"details\":\"").append(details)
		.append("\", \"conferences\":\"");
		Iterator<Conference> iter = conferences.iterator();
		while(iter.hasNext()){
			Conference conference = iter.next();
			json.append(conference.toJSON());
		}
		json.append("\", \"link\":\"").append(getLink()).append("\"}}");
		
		return json.toString();
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(prenom)
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

		if (!(obj instanceof Organisateur)) {
			return false;
		}

		final Organisateur other = (Organisateur) obj;

		return new EqualsBuilder().append(id, other.getId()).append(prenom, other.getPrenom()).isEquals();
	}


}
