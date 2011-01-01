package com.jcertif.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * BO Mot cl�.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
public class MotCle {

	/**
	 * Identifiant du mot cl�.
	 */
	@Id
	@GeneratedValue
	@Column
	private Long id;

	/**
	 * Un mot cl�.
	 */
	@Column
	private String motCle;

	/**
	 * Description d'un mot cl�.
	 */
	@Column
	private String description;

	/**
	 * Le constructeur par d�faut.
	 */
	public MotCle() {
		super();
	}

	/**
	 * Un constructeur.
	 * 
	 * @param motCle
	 *            un mot cl�
	 * @param description
	 *            une description
	 */
	public MotCle(final String motCle, final String description) {
		super();
		this.motCle = motCle;
		this.description = description;
	}

	/**
	 * @return l'identifiant d'un mot cl�.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * D�finit un identifiant.
	 * 
	 * @param id
	 *            un identifiant
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return un mot cl�.
	 */
	public String getMotCle() {
		return motCle;
	}

	/**
	 * D�finit un mot cl�.
	 * 
	 * @param motCle
	 *            un mot cl�
	 */
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	/**
	 * @return une description du mot cl�.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * D�finit la description du mot cl�.
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
		return new HashCodeBuilder().append(motCle).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MotCle)) {
			return false;
		}

		final MotCle other = (MotCle) obj;

		return new EqualsBuilder().append(motCle, other.getMotCle()).isEquals();
	}

}
