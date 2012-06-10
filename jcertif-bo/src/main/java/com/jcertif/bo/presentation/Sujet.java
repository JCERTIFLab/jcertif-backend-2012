package com.jcertif.bo.presentation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jcertif.bo.AbstractBO;

/**
 * BO Sujet.
 * 
 * @author rossi.oddet
 */
@Entity
@XmlRootElement
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Sujet extends AbstractBO {

	private static final long serialVersionUID = 1L;

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
	 * Contructeur par défaut.
	 */
	public Sujet() {
		super();
	}

	/**
	 * Un constructeur.
	 * 
	 * @param libelle
	 *            un libellé
	 * @param description
	 *            une description
	 */
	public Sujet(String libelle, String description) {
		super();
		this.libelle = libelle;
		this.description = description;
	}

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
