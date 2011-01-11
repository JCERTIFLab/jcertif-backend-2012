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
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author Douneg
 * 
 */
@Entity
@XmlRootElement
public class Organisateur extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Liste de conférences.
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
	public Organisateur(Long id, String prenom, String nom, Character sexe,
			String email, String details,
			Set<Conference> conferences) {
		super();
		this.setId(id);
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setSexe(sexe);
		this.setEmail(email);
		this.setDetails(details);
		this.setConferences(conferences);
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
		xml.append("<id>").append(getId()).append("</id>");
		xml.append("<prenom>").append(getPrenom()).append("</prenom>");
		xml.append("<nom>").append(getNom()).append("</nom>");
		xml.append("<sexe>").append(getSexe()).append("</sexe>");
		xml.append("<email>").append(getEmail()).append("</email>");
		xml.append("<details>").append(getDetails()).append("</details>");
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
		return "/organisateur/" + getNom();
	}
	
	public String toJSON() {
		StringBuilder json = new StringBuilder();
		json.append("{\"conference\":{\"id\":\"").append(getId())
		.append("\", \"prenom\":\"").append(getPrenom())
		.append("\", \"nom\":\"").append(getNom())
		.append("\", \"sexe\":\"").append(getSexe())
		.append("\", \"email\":\"").append(getEmail())
		.append("\", \"details\":\"").append(getDetails())
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
		return new HashCodeBuilder().append(this.getId()).append(this.getPrenom())
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

		return new EqualsBuilder().append(this.getId(), other.getId()).append(this.getPrenom(), other.getPrenom()).isEquals();
	}


}
