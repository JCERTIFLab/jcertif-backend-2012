package com.jcertif.presentation.data.bo.cedule;


import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.presentation.data.bo.conference.Conference;
import com.jcertif.presentation.data.bo.salle.Salle;


/**
 * BO CeduleSalle.
 * 
 * @author rossi.oddet
 * 
 */

@XmlRootElement
public class CeduleSalle  {

	private static final long serialVersionUID = 1L;

	/**
	 * Identifiant d'un cedule salle.
	 */

	private Long id;

	/**
	 * Date cedule.
	 */

	private Calendar dateCedule;

	/**
	 * Détails cedule salle.
	 */

	private String details;

	/**
	 * Salle cedulle salle.
	 */

	private Salle salle;

	/**
	 * Staut cedulle salle.
	 */

	private StatutCedule statutCedule;

	/**
	 * Conférence d'une cedule Salle.
	 */

	private Conference conference;


	/**
	 * Un constructeur.
	 */
	public CeduleSalle() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dateCedule
	 */
	public Calendar getDateCedule() {
		return dateCedule;
	}

	/**
	 * @param dateCedule
	 *            the dateCedule to set
	 */
	public void setDateCedule(Calendar dateCedule) {
		this.dateCedule = dateCedule;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the salle
	 */
	public Salle getSalle() {
		return salle;
	}

	/**
	 * @param salle
	 *            the salle to set
	 */
	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	/**
	 * @return the statutCedule
	 */
	public StatutCedule getStatutCedule() {
		return statutCedule;
	}

	/**
	 * @param statutCedule
	 *            the statutCedule to set
	 */
	public void setStatutCedule(StatutCedule statutCedule) {
		this.statutCedule = statutCedule;
	}

	/**
	 * @return the conference
	 */
	public Conference getConference() {
		return conference;
	}

	/**
	 * @param conference the conference to set
	 */
	public void setConference(Conference conference) {
		this.conference = conference;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 * */
	 
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	 
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CeduleSalle)) {
			return false;
		}

		final CeduleSalle other = (CeduleSalle) obj;

		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}
