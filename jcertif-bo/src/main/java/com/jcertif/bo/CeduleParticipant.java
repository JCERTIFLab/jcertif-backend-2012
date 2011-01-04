package com.jcertif.bo;
/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
/**
 * @author chrisbel
 */
@Entity
public class CeduleParticipant {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Calendar dateCedule;
	
	@Column
	private String details;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conference_id")
	private Conference conference;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "partcipant_id")
	private Participant participant;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "statut_cedule_id")
	private StatutCedule statutCedule;

	/**
	 * Constructor
	 */
	public CeduleParticipant() {

	}
	

	/**
	 * Constructor
	 */
	public CeduleParticipant(Long id, Calendar dateCedule, String details,
			 Participant participant,Conference conference,
			StatutCedule statutCedule) {
		this.id = id;
		this.dateCedule = dateCedule;
		this.details = details;
		this.conference = conference;
		this.participant = participant;
		this.statutCedule = statutCedule;
	}


	/**
	 * @return the idTODO
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to setTODOid
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dateCeduleTODO
	 */
	public Calendar getDateCedule() {
		return dateCedule;
	}

	/**
	 * @param dateCedule
	 *            the dateCedule to setTODOdateCedule
	 */
	public void setDateCedule(Calendar dateCedule) {
		this.dateCedule = dateCedule;
	}

	/**
	 * @return the detailsTODO
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to setTODOdetails
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the statutCeduleTODO
	 */
	public StatutCedule getStatutCedule() {
		return statutCedule;
	}

	/**
	 * @param statutCedule
	 *            the statutCedule to setTODOstatutCedule
	 */
	public void setStatutCedule(StatutCedule statutCedule) {
		this.statutCedule = statutCedule;
	}

	
	
	/**
	 * @return the conferenceTODO
	 */
	public Conference getConference() {
		return conference;
	}

	/**
	 * @param conference the conference to setTODOconference
	 */
	public void setConference(Conference conference) {
		this.conference = conference;
	}

	/**
	 * @return the participantTODO
	 */
	public Participant getParticipant() {
		return participant;
	}

	/**
	 * @param participant the participant to setTODOparticipant
	 */
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(details).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CeduleParticipant)) {
			return false;
		}

		final CeduleParticipant other = (CeduleParticipant) obj;

		return new EqualsBuilder().append(id, other.getId()).append(details, other.getDetails()).isEquals();
	}
}
