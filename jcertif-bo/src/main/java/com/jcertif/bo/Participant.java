package com.jcertif.bo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 
 * @author Douneg
 */
@Entity
public class Participant extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private String dateinscription;
	@Column
	private String presentationsoumise;
	@Column
	private String cvsoumis;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "role_participant_id")
	private RoleParticipant roleparticipant;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "conference_id")
	private Conference conference;

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "cedule_particpant_id")
	private Set<CeduleParticipant> ceduleparticipants = new HashSet<CeduleParticipant>();

	/**
	 * Constructor
	 */
	public Participant() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor
	 */
	public Participant(Long id, String dateinscription, String salutation,
			String specialite, String prenom, String nom, Character sexe_MF,
			String email, String telephone, String presentationsoumise,
			String cvsoumis, String details, RoleParticipant roleparticipant,
			Conference conference, Set<CeduleParticipant> ceduleparticipants) {
		super();
		this.id = id;
		this.dateinscription = dateinscription;
		this.salutation = salutation;
		this.specialite = specialite;
		this.prenom = prenom;
		this.nom = nom;
		this.sexe_MF = sexe_MF;
		this.email = email;
		this.telephone = telephone;
		this.presentationsoumise = presentationsoumise;
		this.cvsoumis = cvsoumis;
		this.details = details;
		this.roleparticipant = roleparticipant;
		this.conference = conference;
		this.ceduleparticipants = ceduleparticipants;
	}

	/**
	 * Creates this.
	 * 
	 * @param id
	 * @param dateinscription
	 * @param salutation
	 * @param prenom
	 * @param nom
	 * @param sexe
	 * @param email
	 * @param telephone
	 * @param presentationsoumise
	 * @param cvsoumis
	 * @param details
	 */
	public Participant(Long id, String dateinscription, String salutation,
			String prenom, String nom, Character sexe_MF, String email,
			String telephone, String presentationsoumise, String cvsoumis,
			String details) {
		super();
		this.id = id;
		this.dateinscription = dateinscription;
		this.salutation = salutation;
		this.prenom = prenom;
		this.nom = nom;
		this.sexe_MF = sexe_MF;
		this.email = email;
		this.telephone = telephone;
		this.presentationsoumise = presentationsoumise;
		this.cvsoumis = cvsoumis;
		this.details = details;
	}

	/**
	 * @return the salutationTODO
	 */
	public String getSalutation() {
		return salutation;
	}

	/**
	 * @param salutation
	 *            the salutation to setTODOsalutation
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	/**
	 * @return the presentationsoumiseTODO
	 */
	public String getPresentationsoumise() {
		return presentationsoumise;
	}

	/**
	 * @param presentationsoumise
	 *            the presentationsoumise to setTODOpresentationsoumise
	 */
	public void setPresentationsoumise(String presentationsoumise) {
		this.presentationsoumise = presentationsoumise;
	}

	/**
	 * @return the cvsoumisTODO
	 */
	public String getCvsoumis() {
		return cvsoumis;
	}

	/**
	 * @param cvsoumis
	 *            the cvsoumis to setTODOcvsoumis
	 */
	public void setCvsoumis(String cvsoumis) {
		this.cvsoumis = cvsoumis;
	}

	/**
	 * @return the roleparticipantTODO
	 */
	public RoleParticipant getRoleparticipant() {
		return roleparticipant;
	}

	/**
	 * @param roleparticipant
	 *            the roleparticipant to setTODOroleparticipant
	 */
	public void setRoleparticipant(RoleParticipant roleparticipant) {
		this.roleparticipant = roleparticipant;
	}

	/**
	 * @return the conferenceTODO
	 */
	public Conference getConference() {
		return conference;
	}

	/**
	 * @param conference
	 *            the conference to setTODOconference
	 */
	public void setConference(Conference conference) {
		this.conference = conference;
	}

	/**
	 * @return the ceduleparticipantsTODO
	 */
	public Set<CeduleParticipant> getCeduleparticipants() {
		return ceduleparticipants;
	}

	/**
	 * @param ceduleparticipants
	 *            the ceduleparticipants to setTODOceduleparticipants
	 */
	public void setCeduleparticipants(Set<CeduleParticipant> ceduleparticipants) {
		this.ceduleparticipants = ceduleparticipants;
	}

	/**
	 * @return the dateinscriptionTODO
	 */
	public String getDateinscription() {
		return dateinscription;
	}

	/**
	 * @param dateinscription
	 *            the dateinscription to setTODOdateinscription
	 */
	public void setDateinscription(String dateinscription) {
		this.dateinscription = dateinscription;
	}

	/**
	 * @return the specialiteTODO
	 */
	public String getSpecialite() {
		return specialite;
	}

	/**
	 * @param specialite
	 *            the specialite to setTODOspecialite
	 */
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String toXML() {
		StringBuilder xml = new StringBuilder();
		xml.append("<participant>");
		xml.append("<id>").append(id).append("</id>");
		xml.append("<dateinscription>").append(dateinscription)
				.append("</dateinscription>");
		xml.append("<salutation>").append(salutation).append("</salutation>");
		xml.append("<prenom>").append(id).append("</prenom>");
		xml.append("<nom>").append(nom).append("</nom>");
		xml.append("<sexe>").append(sexe_MF).append("</sexe>");
		xml.append("<email>").append(email).append("</email>");
		xml.append("<telephone>").append(telephone).append("</telephone>");
		xml.append("<presentationsoumise>").append(presentationsoumise)
				.append("</presentationsoumise>");
		xml.append("<cvsoumis>").append(cvsoumis).append("</cvsoumis>");
		xml.append("<details>").append(details).append("</details>");

		xml.append("<rolesParticipants>").append(roleparticipant.toXML())
				.append("</rolesParticipants>");
		xml.append("<conferences>").append(conference.toXML())
				.append("</conference>");
		xml.append("<ceduleparticipants>");
		Iterator<CeduleParticipant> iter = ceduleparticipants.iterator();
		while (iter.hasNext()) {
			CeduleParticipant cedule = iter.next();
			xml.append(cedule.toXML());
		}
		xml.append("</ceduleparticipants>");
		xml.append("<link>").append(getLink()).append("</link>");
		xml.append("</participant>");

		return xml.toString();
	}

	private String getLink() {
		return "/participant/" + nom;
	}

	public String toJSON() {
		StringBuilder json = new StringBuilder();
		json.append("{\"participant\":{\"id\":\"").append(id)
				.append("\", \"dateinscription\":\"").append(dateinscription)
				.append("\", \"salutation\":\"").append(salutation)
				.append("\", \"prenom\":\"").append(prenom)
				.append("\", \"nom\":\"").append(nom).append("\", \"sexe\":\"")
				.append(sexe_MF).append("\", \"email\":\"").append(email)
				.append("\", \"presentationsoumise\":\"")
				.append(presentationsoumise).append("\", \"cvsoumis\":\"")
				.append(cvsoumis).append("\", \"details\":\"").append(details)
				.append(roleparticipant.toJSON()).append(conference.toJSON());
		Iterator<CeduleParticipant> iter = ceduleparticipants.iterator();
		while (iter.hasNext()) {
			CeduleParticipant cedule = iter.next();
			json.append(cedule.toJSON());
		}
		json.append("\", \"link\":\"").append(getLink()).append("\"}}");

		return json.toString();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(prenom).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Participant)) {
			return false;
		}

		final Participant other = (Participant) obj;

		return new EqualsBuilder().append(id, other.getId())
				.append(prenom, other.getPrenom()).isEquals();
	}
}
