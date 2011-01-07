package com.jcertif.bo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * BO CommiteRevisionPresentation.
 * 
 * @author rossi.oddet
 * 
 */
@Entity(name="commite_revision_presentation")
public class ComiteRevisionPresentation {

	/**
	 * Clé composite.
	 */
	@EmbeddedId
	private ComiteRevisionPresentationPK comiteRevisionPresentationPK;

	/**
	 * La date de révision.
	 */
	@Column
	private Calendar dateRevision;

	/**
	 * @return the comiteRevisionPresentationPK
	 */
	public ComiteRevisionPresentationPK getComiteRevisionPresentationPK() {
		return comiteRevisionPresentationPK;
	}

	/**
	 * @param comiteRevisionPresentationPK
	 *            the comiteRevisionPresentationPK to set
	 */
	public void setComiteRevisionPresentationPK(
			ComiteRevisionPresentationPK comiteRevisionPresentationPK) {
		this.comiteRevisionPresentationPK = comiteRevisionPresentationPK;
	}

	/**
	 * @return the dateRevision
	 */
	public Calendar getDateRevision() {
		return dateRevision;
	}

	/**
	 * @param dateRevision
	 *            the dateRevision to set
	 */
	public void setDateRevision(Calendar dateRevision) {
		this.dateRevision = dateRevision;
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(comiteRevisionPresentationPK)
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

		if (!(obj instanceof ComiteRevisionPresentation)) {
			return false;
		}

		final ComiteRevisionPresentation other = (ComiteRevisionPresentation) obj;

		return new EqualsBuilder().append(comiteRevisionPresentationPK, other.getComiteRevisionPresentationPK()).isEquals();
	}

}
