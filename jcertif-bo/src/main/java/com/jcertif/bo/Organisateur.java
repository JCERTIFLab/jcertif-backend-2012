/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.bo;

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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author Utilisateur
 * 
 */
@Entity
public class Organisateur {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
	private Long id;

	
	/**
	 * 
	 */
	@Column
	private String prenom;
	@Column
	private String nom;
	@Column
	private Character sexe;
	@Column
	private String email;
	@Column
	private String telephone;
	@Column
	private String details;
	
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
			String email, String telephone, String details,
			Set<Conference> conferences) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.sexe = sexe;
		this.email = email;
		this.telephone = telephone;
		this.details = details;
		this.conferences = conferences;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the sexeMFTODO
	 */
	public Character getSexeMF() {
		return sexe;
	}

	/**
	 * @param sexeMF the sexeMF to setTODOsexeMF
	 */
	public void setSexeMF(Character sexeMF) {
		this.sexe = sexeMF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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
		xml.append("<sexe>").append(sexe).append("</sexe>");
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
		.append("\", \"sexe\":\"").append(sexe)
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
