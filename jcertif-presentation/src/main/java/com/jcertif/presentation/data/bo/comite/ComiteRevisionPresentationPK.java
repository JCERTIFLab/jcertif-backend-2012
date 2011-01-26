package com.jcertif.presentation.data.bo.comite;



import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;



/**
 * Clé composite pour {@link ComiteRevisionPresentation}.
 * 
 * @author rossi.oddet
 * 
 */

public class ComiteRevisionPresentationPK implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Identifiant comité organisation.
	 */

	private Long comiteOrganisationId;

	/**
	 * Identifiant présentation.
	 */

	private Long presentationId;

	/**
	 * @return the comiteOrganisationId
	 */
	public Long getComiteOrganisationId() {
		return comiteOrganisationId;
	}

	/**
	 * @param comiteOrganisationId
	 *            the comiteOrganisationId to set
	 */
	public void setComiteOrganisationId(Long comiteOrganisationId) {
		this.comiteOrganisationId = comiteOrganisationId;
	}

	/**
	 * @return the presentationId
	 */
	public Long getPresentationId() {
		return presentationId;
	}

	/**
	 * @param presentationId
	 *            the presentationId to set
	 */
	public void setPresentationId(Long presentationId) {
		this.presentationId = presentationId;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	 
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(comiteOrganisationId)
				.append(presentationId).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	 
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ComiteRevisionPresentationPK)) {
			return false;
		}

		final ComiteRevisionPresentationPK other = (ComiteRevisionPresentationPK) obj;

		return new EqualsBuilder()
				.append(comiteOrganisationId, other.getComiteOrganisationId())
				.append(presentationId, other.getPresentationId()).isEquals();
	}

}
