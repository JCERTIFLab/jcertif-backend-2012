package com.jcertif.bo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * BO Rappel envoye.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
public class RappelEnvoye {

	/**
	 * Cl� composite de rappel envoy�.
	 */
	@EmbeddedId
	private RappelEnvoyePK rappelEnvoyePK;

	@Column
	private Calendar dateReponseRecu;

	/**
	 * @return the rappelEnvoyePK
	 */
	public RappelEnvoyePK getRappelEnvoyePK() {
		return rappelEnvoyePK;
	}

	/**
	 * @param rappelEnvoyePK
	 *            the rappelEnvoyePK to set
	 */
	public void setRappelEnvoyePK(RappelEnvoyePK rappelEnvoyePK) {
		this.rappelEnvoyePK = rappelEnvoyePK;
	}

	/**
	 * @return the dateReponseRecu
	 */
	public Calendar getDateReponseRecu() {
		return dateReponseRecu;
	}

	/**
	 * @param dateReponseRecu
	 *            the dateReponseRecu to set
	 */
	public void setDateReponseRecu(Calendar dateReponseRecu) {
		this.dateReponseRecu = dateReponseRecu;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(rappelEnvoyePK).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RappelEnvoye)) {
			return false;
		}

		final RappelEnvoye other = (RappelEnvoye) obj;

		return new EqualsBuilder().append(rappelEnvoyePK,
				other.getRappelEnvoyePK()).isEquals();
	}

}
