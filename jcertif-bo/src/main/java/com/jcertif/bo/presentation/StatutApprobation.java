package com.jcertif.bo.presentation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.bo.AbstractBO;

/**
 * BO Statut approbation.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
@XmlRootElement
public class StatutApprobation extends AbstractBO {

	private static final long serialVersionUID = 1L;

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
	 * Un constructeur.
	 */
	public StatutApprobation() {
		super();
	}

	/**
	 * Un constructeur.
	 * 
	 * @param codeStatut
	 *            un code statut
	 * @param description
	 *            une description
	 */
	public StatutApprobation(String codeStatut, String description) {
		super();
		this.codeStatut = codeStatut;
		this.description = description;
	}

	/**
	 * @return l'identifiant d'un statut d'approbation
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Définit l'identifiant d'un statut d'approbation
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
	 * Définit le code statut.
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
	 * Définit une description.
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
		return new HashCodeBuilder().append(codeStatut).toHashCode();
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
				.isEquals();
	}

}
