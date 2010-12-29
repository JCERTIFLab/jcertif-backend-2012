package com.jcertif.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * BO Sujet.
 * 
 * @author rossi.oddet
 */
@Entity
public class Sujet {

	/**
	 * Identifiant du Sujet.
	 */
	@Id
	@GeneratedValue
	@Column
	private Long id;

	/**
	 * Libellé du sujet.
	 */
	@Column
	private String libelle;

	/**
	 * Description du sujet.
	 */
	@Column
	private String description;

	/**
	 * @return l'identifiant du sujet.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            un identifiant
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return le libellé du sujet
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 *            un libellé
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return la description du sujet
	 */
	public String getDescription() {
		return description;
	}

	/**
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
		return new HashCodeBuilder().append(libelle).append(description)
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

		if (!(obj instanceof Sujet)) {
			return false;
		}

		final Sujet other = (Sujet) obj;

		return new EqualsBuilder().append(libelle, other.getLibelle())
				.append(description, other.getDescription()).isEquals();
	}

}
