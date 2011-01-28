package com.jcertif.presentation.data.bo.comite;



import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.presentation.data.bo.AbstractBO;


/**
 * BO CommiteRevisionPresentation.
 * 
 * @author rossi.oddet
 * 
 */

public class ComiteRevisionPresentation extends AbstractBO{

	private static final long serialVersionUID = 1L;

	/**
	 * Cl� composite.
	 */

	private ComiteRevisionPresentationPK comiteRevisionPresentationPK;

	/**
	 * La date de r�vision.
	 */

	private Calendar dateRevision;

	private Set<RappelEnvoye> rappelsEnvoyesInternal;

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
	 * @return the rappelsEnvoyesInternal
	 */
	protected Set<RappelEnvoye> getRappelsEnvoyesInternal() {
		if (rappelsEnvoyesInternal == null) {
			rappelsEnvoyesInternal = new HashSet<RappelEnvoye>();
		}
		return rappelsEnvoyesInternal;
	}

	/**
	 * @param rappelsEnvoyesInternal
	 *            the rappelsEnvoyesInternal to set
	 */
	protected void setRappelsEnvoyesInternal(
			Set<RappelEnvoye> rappelsEnvoyesInternal) {
		this.rappelsEnvoyesInternal = rappelsEnvoyesInternal;
	}

	/**
	 * @return the rappelsEnvoyesInternal
	 */
	public Set<RappelEnvoye> getRappelsEnvoyes() {
		return rappelsEnvoyesInternal;
	}

	/**
	 * Ajouter un rappel envoy�.
	 * 
	 * @param rappelEnvoye
	 *            un rappel envoy�.
	 * @return le r�sultat de l'ajout.
	 */
	public boolean addRappelEnvoye(final RappelEnvoye rappelEnvoye) {
		return this.getRappelsEnvoyesInternal().add(rappelEnvoye);
	}

	/**
	 * Supprime un rappel envoy�.
	 * 
	 * @param rappelEnvoye
	 *            un rappel envoy�
	 * @return le r�sultat de la suppression
	 */
	public boolean removeRappelEnvoye(final RappelEnvoye rappelEnvoye) {
		return this.getRappelsEnvoyesInternal().remove(rappelEnvoye);
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

		return new EqualsBuilder().append(comiteRevisionPresentationPK,
				other.getComiteRevisionPresentationPK()).isEquals();
	} 

}
