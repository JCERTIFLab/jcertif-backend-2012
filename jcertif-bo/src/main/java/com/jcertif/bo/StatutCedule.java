package com.jcertif.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * BO Statut Cedule.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
public class StatutCedule {

	/**
	 * Identifiant du statut cedule.
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Code du statut cedule.
	 */
	@Column
	private String code;

	/**
	 * Description du statut cedule.
	 */
	@Column
	private String description;

	/**
	 * Un constructeur.
	 */
	public StatutCedule() {
		super();
	}

	/**
	 * Un constructeur.
	 * 
	 * @param code
	 *            un code
	 * @param description
	 *            une description
	 */
	public StatutCedule(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	/**
	 * @return l'identifiant du statut cedule.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Définit un identifiant du statut cedule.
	 * 
	 * @param id
	 *            un identifiant
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return le code du statut cedule.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Définit le code de statut cedule.
	 * 
	 * @param code
	 *            un code de statut cedule
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return la description du statut cedule
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Définit la description du statut cedule.
	 * 
	 * @param description
	 *            une description du statut cedule.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(code).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatutCedule)) {
			return false;
		}

		final StatutCedule other = (StatutCedule) obj;

		return new EqualsBuilder().append(code, other.getCode()).isEquals();
	}

}
