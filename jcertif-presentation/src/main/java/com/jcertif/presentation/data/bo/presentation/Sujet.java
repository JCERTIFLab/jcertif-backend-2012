package com.jcertif.presentation.data.bo.presentation;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


/**
 * BO Sujet.
 * 
 * @author rossi.oddet
 */

@XmlRootElement
public class Sujet {

	private static final long serialVersionUID = 1L;

	/**
	 * Identifiant du Sujet.
	 */

	private Long id;

	/**
	 * Libell� du sujet.
	 */

	private String libelle;

	/**
	 * Description du sujet.
	 */

	private String description;

	/**
	 * Contructeur par d�faut.
	 */
	public Sujet() {
		super();
	}

	/**
	 * Un constructeur.
	 * 
	 * @param libelle
	 *            un libell�
	 * @param description
	 *            une description
	 */
	public Sujet(String libelle, String description) {
		super();
		this.libelle = libelle;
		this.description = description;
	}

	/**
	 * Liste de pr�sentations.
	 */
	
	private List<PropositionPresentation> presentationsInternal;

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
	 * @return le libell� du sujet
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 *            un libell�
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
	 * @return la liste des pr�sentations du sujet
	 */
	protected List<PropositionPresentation> getPresentationsInternal() {
		if (presentationsInternal == null) {
			presentationsInternal = new ArrayList<PropositionPresentation>();
		}
		return presentationsInternal;
	}

	/**
	 * D�finit une liste de pr�sentation.
	 * 
	 * @param presentationsInternal
	 *            une liste de pr�sentation
	 */
	protected void setPresentationsInternal(
			List<PropositionPresentation> presentationsInternal) {
		this.presentationsInternal = presentationsInternal;
	}

	/**
	 * @return une liste non modifiable de pr�sentation.
	 */
	public List<PropositionPresentation> getPresentations() {
		return Collections.unmodifiableList(this.getPresentationsInternal());
	}

	/**
	 * Ajoute une pr�sentation � un sujet.
	 * 
	 * @param presentation
	 *            une pr�sentation
	 * @return le r�sultat de l'ajout
	 */
	public boolean addPresentation(PropositionPresentation presentation) {
		return this.getPresentationsInternal().add(presentation);
	}

	/**
	 * Supprimes une pr�sentation.
	 * 
	 * @param presentation
	 *            une pr�sentation
	 * @return le r�sultat de la suppression
	 */
	public boolean removePresentation(PropositionPresentation presentation) {
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
