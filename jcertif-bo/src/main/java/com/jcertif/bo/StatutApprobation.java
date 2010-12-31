package com.jcertif.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * BO Statut approbation.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
public class StatutApprobation {

	/**
	 * Identifiant d'un statut d'approbation.
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Un code de statut.
	 */
	@Column
	private String codeStatut;

	/**
	 * Une description du statut d'approbation.
	 */
	@Column
	private String description;

	/**
	 * @return l'identifiant d'un statut d'approbation
	 */
	public Long getId() {
		return id;
	}

	/**
	 * D�finit l'identifiant d'un statut d'approbation
	 * 
	 * @param id
	 *            un identifiant
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return le code statut
	 */
	public String getCodeStatut() {
		return codeStatut;
	}

	/**
	 * D�finit le code statut.
	 * 
	 * @param codeStatut
	 *            un code statut
	 */
	public void setCodeStatut(String codeStatut) {
		this.codeStatut = codeStatut;
	}

	/**
	 * @return une description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * D�finit une description.
	 * 
	 * @param description
	 *            une description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codeStatut).append(description)
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

		if (!(obj instanceof StatutApprobation)) {
			return false;
		}

		final StatutApprobation other = (StatutApprobation) obj;

		return new EqualsBuilder().append(codeStatut, other.getCodeStatut())
				.append(description, other.getDescription()).isEquals();
	}


}
