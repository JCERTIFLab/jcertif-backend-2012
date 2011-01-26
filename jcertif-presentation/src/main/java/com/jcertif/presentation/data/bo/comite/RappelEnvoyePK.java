package com.jcertif.presentation.data.bo.comite;



import java.io.Serializable;
import java.util.Calendar;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;




/**
 * Clé composite pour RappelEnvoye.
 * 
 * @author rossi.oddet
 * 
 */

public class RappelEnvoyePK implements Serializable {

	private static final long serialVersionUID = 1L;


	private Long comiteRvsPrstCmteOrgaId;
	
	private Long comiteRevisPrestPrestId;

	private Calendar dateRappel;

	/**
	 * @return the comiteRvsPrstCmteOrgaId
	 */
	public Long getComiteRvsPrstCmteOrgaId() {
		return comiteRvsPrstCmteOrgaId;
	}

	/**
	 * @param comiteRvsPrstCmteOrgaId
	 *            the comiteRvsPrstCmteOrgaId to set
	 */
	public void setComiteRvsPrstCmteOrgaId(Long comiteRvsPrstCmteOrgaId) {
		this.comiteRvsPrstCmteOrgaId = comiteRvsPrstCmteOrgaId;
	}

	/**
	 * @return the comiteRevisPrestPrestId
	 */
	public Long getComiteRevisPrestPrestId() {
		return comiteRevisPrestPrestId;
	}

	/**
	 * @param comiteRevisPrestPrestId
	 *            the comiteRevisPrestPrestId to set
	 */
	public void setComiteRevisPrestPrestId(Long comiteRevisPrestPrestId) {
		this.comiteRevisPrestPrestId = comiteRevisPrestPrestId;
	}

	/**
	 * @return the dateRappel
	 */
	public Calendar getDateRappel() {
		return dateRappel;
	}

	/**
	 * @param dateRappel
	 *            the dateRappel to set
	 */
	public void setDateRappel(Calendar dateRappel) {
		this.dateRappel = dateRappel;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(comiteRvsPrstCmteOrgaId)
				.append(comiteRevisPrestPrestId).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RappelEnvoyePK)) {
			return false;
		}

		final RappelEnvoyePK other = (RappelEnvoyePK) obj;

		return new EqualsBuilder()
				.append(comiteRvsPrstCmteOrgaId,
						other.getComiteRvsPrstCmteOrgaId())
				.append(comiteRevisPrestPrestId,
						other.getComiteRevisPrestPrestId())
				.append(dateRappel, other.getDateRappel()).isEquals();
	} 
}
