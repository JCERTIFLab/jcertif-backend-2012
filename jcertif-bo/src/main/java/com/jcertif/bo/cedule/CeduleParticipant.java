package com.jcertif.bo.cedule;

/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.bo.AbstractBO;
import com.jcertif.bo.participant.Participant;

/**
 * @author chrisbel
 */
@Entity
@XmlRootElement
public class CeduleParticipant extends AbstractBO {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Calendar dateCedule;

	@Column
	private String details;

	@Column(name = "participant_id")
	private Long participantId;

	@Column(name = "evenement_id")
	private Long evenementId;

	@ManyToOne(fetch = FetchType.EAGER)
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
	public CeduleParticipant(Long id, Calendar dateCedule, String details, Participant participant,
			Evenement event, StatutCedule statutCedule) {
		this.id = id;
		this.dateCedule = dateCedule;
		this.details = details;
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
	 * @return the participantId
	 */
	public Long getParticipantId() {
		return participantId;
	}

	/**
	 * @param participantId
	 *            the participantId to set
	 */
	public void setParticipantId(Long participantId) {
		this.participantId = participantId;
	}

	/**
	 * @return the evenementId
	 */
	public Long getEvenementId() {
		return evenementId;
	}

	/**
	 * @param evenementId
	 *            the evenementId to set
	 */
	public void setEvenementId(Long evenementId) {
		this.evenementId = evenementId;
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

		return new EqualsBuilder().append(id, other.getId()).append(details, other.getDetails())
				.isEquals();
	}
}
