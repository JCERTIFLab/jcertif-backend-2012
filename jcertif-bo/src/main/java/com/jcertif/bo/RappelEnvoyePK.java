package com.jcertif.bo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Clé composite pour RappelEnvoye.
 * 
 * @author rossi.oddet
 * 
 */
@Embeddable
public class RappelEnvoyePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "commite_rvs_prst_Cmte_orga_id")
	private Long comiteRvsPrstCmteOrgaId;
	@Column(name = "commite_revis_prest_prest_id")
	private Long comiteRevisPrestPrestId;
	@Column
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
