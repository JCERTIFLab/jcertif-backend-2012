package com.jcertif.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

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

	@ManyToMany
	@JoinTable(name = "presentation_sujet", joinColumns = @JoinColumn(name = "sujet_id"), inverseJoinColumns = @JoinColumn(name = "presentation_id"))
	private List<Presentation> presentationsInternal;

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
	 * @return la liste des présentations du sujet
	 */
	protected List<Presentation> getPresentationsInternal() {
		if (presentationsInternal == null) {
			presentationsInternal = new ArrayList<Presentation>();
		}
		return presentationsInternal;
	}

	/**
	 * Définit une liste de présentation.
	 * 
	 * @param presentationsInternal
	 *            une liste de présentation
	 */
	protected void setPresentationsInternal(
			List<Presentation> presentationsInternal) {
		this.presentationsInternal = presentationsInternal;
	}

	/**
	 * @return une liste non modifiable de présentation.
	 */
	public List<Presentation> getPresentations() {
		return Collections.unmodifiableList(this.getPresentationsInternal());
	}

	/**
	 * Ajoute une présentation à un sujet.
	 * 
	 * @param presentation
	 *            une présentation
	 * @return le résultat de l'ajout
	 */
	public boolean addPresentation(Presentation presentation) {
		return this.getPresentationsInternal().add(presentation);
	}

	/**
	 * Supprimes une présentation.
	 * 
	 * @param presentation
	 *            une présentation
	 * @return le résultat de la suppression
	 */
	public boolean removePresentation(Presentation presentation) {
		return this.getPresentationsInternal().remove(presentation);
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
