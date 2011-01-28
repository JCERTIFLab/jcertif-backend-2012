package com.jcertif.presentation.data.bo.cedule;


import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.presentation.data.bo.AbstractBO;
import com.jcertif.presentation.data.bo.participant.Participant;

/**
 * @author Badr
 */

@XmlRootElement
public class CeduleParticipant extends AbstractBO{

	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	
	private Calendar dateCedule;
	
	
	private String details;

	private Evenement evenement;

	

	private Participant participant;

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
			 Participant participant,Evenement event,
			StatutCedule statutCedule) {
		this.id = id;
		this.dateCedule = dateCedule;
		this.details = details;
		this.evenement = event;
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
	 * @return the evenement
	 */
	public Evenement getEvenement() {
		return evenement;
	}


	/**
	 * @param evenement the evenement to set
	 */
	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
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
