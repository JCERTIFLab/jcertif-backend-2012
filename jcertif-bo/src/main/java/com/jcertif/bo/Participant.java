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
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 
 * @author Douneg
 */
@Entity
@XmlRootElement
public class Participant extends Person {

	private static final long serialVersionUID = 1L;
	@Column
	private String dateInscription;
	@Column
	private String presentationSoumise;
	@Column
	private String cvSoumis;
	
	@Column
	private String compagnie;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "role_participant_id")
	private RoleParticipant roleparticipant;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "type_participant_id")
	private TypeParticipant typeParticipant;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "conference_id")
	private Conference conference;

        @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "profil_utilisateur_id")
	private ProfilUtilisateur profilUtilisateur;

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "participant_id")
	private Set<CeduleParticipant> ceduleparticipants = new HashSet<CeduleParticipant>();

	/**
	 * Constructor
	 */
	public Participant() {
		super();
	}

	/**
	 * Constructor
	 */
	public Participant(Long id, String dateinscription, String salutation,
			String specialite, String prenom, String nom, Character sexe,
			String email, String presentationsoumise,
			String cvsoumis, String details, RoleParticipant roleparticipant,
			Conference conference, Set<CeduleParticipant> ceduleparticipants) {
		super();
		this.setId(id);
		this.dateInscription = dateinscription;
		this.setSalutation(salutation);
		this.setSpecialite(specialite);
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setSexe(sexe);
		this.setEmail(email);
		this.presentationSoumise = presentationsoumise;
		this.cvSoumis = cvsoumis;
		this.setDetails(details);
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
			String prenom, String nom, Character sexe_MF, String email, String presentationsoumise, String cvsoumis,
			String details) {
		super();
		this.setId(id);
		this.dateInscription = dateinscription;
		this.setSalutation(salutation);
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setSexe(sexe_MF);
		this.setEmail(email);
		this.presentationSoumise = presentationsoumise;
		this.cvSoumis = cvsoumis;
		this.setDetails(details);
	}
/**
	 * @return the profilUtilisateur
	 */
    public ProfilUtilisateur getProfilUtilisateur() {
        return profilUtilisateur;
    }
/**
	 * @param profilUtilisateur the profilUtilisateur to set
	 */
    public void setProfilUtilisateur(ProfilUtilisateur profilUtilisateur) {
        this.profilUtilisateur = profilUtilisateur;
    }

	/**
	 * @return the dateInscription
	 */
	public String getDateInscription() {
		return dateInscription;
	}

	/**
	 * @param dateInscription the dateInscription to set
	 */
	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}

	/**
	 * @return the presentationSoumise
	 */
	public String getPresentationSoumise() {
		return presentationSoumise;
	}

	/**
	 * @param presentationSoumise the presentationSoumise to set
	 */
	public void setPresentationSoumise(String presentationSoumise) {
		this.presentationSoumise = presentationSoumise;
	}

	/**
	 * @return the cvSoumis
	 */
	public String getCvSoumis() {
		return cvSoumis;
	}

	/**
	 * @param cvSoumis the cvSoumis to set
	 */
	public void setCvSoumis(String cvSoumis) {
		this.cvSoumis = cvSoumis;
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
	 * @return the typeParticipant
	 */
	public TypeParticipant getTypeParticipant() {
		return typeParticipant;
	}

	/**
	 * @param typeParticipant the typeParticipant to set
	 */
	public void setTypeParticipant(TypeParticipant typeParticipant) {
		this.typeParticipant = typeParticipant;
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
	 * @return the compagnie
	 */
	public String getCompagnie() {
		return compagnie;
	}

	/**
	 * @param compagnie the compagnie to set
	 */
	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId())
				.append(this.getPrenom()).toHashCode();
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

		return new EqualsBuilder().append(this.getId(), other.getId())
				.append(this.getPrenom(), other.getPrenom()).isEquals();
	}
	
	 public String toXML() {
         StringBuilder xml = new StringBuilder();
         xml.append("<participant>");
         xml.append("<id>").append(getId()).append("</id>");
         xml.append("<dateinscription>").append(dateInscription)
                         .append("</dateinscription>");
         xml.append("<salutation>").append(getSalutation()).append("</salutation>");
         xml.append("<prenom>").append(getPrenom()).append("</prenom>");
         xml.append("<nom>").append(getNom()).append("</nom>");
         xml.append("<sexe>").append(getSexe()).append("</sexe>");
         xml.append("<email>").append(getEmail()).append("</email>");
         xml.append("<presentationsoumise>").append(presentationSoumise)
                         .append("</presentationsoumise>");
         xml.append("<cvsoumis>").append(cvSoumis).append("</cvsoumis>");
         xml.append("<details>").append(getDetails()).append("</details>");

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
         return "/participant/" + getNom();
 }

 public String toJSON() {
         StringBuilder json = new StringBuilder();
         json.append("{\"participant\":{\"id\":\"").append(getId())
                         .append("\", \"dateinscription\":\"").append(dateInscription)
                         .append("\", \"salutation\":\"").append(getSalutation())
                         .append("\", \"prenom\":\"").append(getPrenom())
                         .append("\", \"nom\":\"").append(getNom())
                         .append("\", \"sexe\":\"").append(getSexe())
                         .append("\", \"email\":\"").append(getEmail())
                         .append("\", \"presentationsoumise\":\"").append(presentationSoumise)
                         .append("\", \"cvsoumis\":\"").append(cvSoumis)
                         .append("\", \"details\":\"").append(getDetails())
                         .append(roleparticipant.toJSON()).append(conference.toJSON());
         Iterator<CeduleParticipant> iter = ceduleparticipants.iterator();
         while (iter.hasNext()) {
                 CeduleParticipant cedule = iter.next();
                 json.append(cedule.toJSON());
         }
         json.append("\", \"link\":\"").append(getLink()).append("\"}}");

         return json.toString();
 }

}
