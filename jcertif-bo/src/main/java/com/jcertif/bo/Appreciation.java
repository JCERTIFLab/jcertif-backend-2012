package com.jcertif.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * BO Appreciation.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
@XmlRootElement
public class Appreciation {

	/**
	 * Identifiant d'une appreciation.
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Le code de l'appr�ciation.
	 */
	@Column(nullable = false)
	private String codeAppreciation;

	/**
	 * La description de l'appreciation.
	 */
	@Column
	private String description;

	/**
	 * Liste de pr�sentations.
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "appreciation_presentation", joinColumns = @JoinColumn(name = "appreciation_id"), inverseJoinColumns = @JoinColumn(name = "presentation_id"))
	private List<Presentation> presentationsInternal;

	/**
	 * Constructeur par d�faut.
	 */
	public Appreciation() {
		super();
	}

	/**
	 * Un constructeur.
	 * 
	 * @param codeAppreciation
	 *            un code appr�ciation
	 * @param description
	 *            une description
	 */
	public Appreciation(String codeAppreciation, String description) {
		super();
		this.codeAppreciation = codeAppreciation;
		this.description = description;
	}

	/**
	 * @return l'identifiant de l'appr�ciation.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * D�finit l'identifiant de l'appr�ciation.
	 * 
	 * @param id
	 *            un identifiant
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return la description de l'appr�ciation.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * D�finit une description de l'appr�ciation.
	 * 
	 * @param description
	 *            une description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return le code de l'appr�ciation
	 */
	public String getCodeAppreciation() {
		return codeAppreciation;
	}

	/**
	 * D�finit le code de l'appr�ciation.
	 * 
	 * @param codeAppreciation
	 *            un code d'appr�ciation
	 */
	public void setCodeAppreciation(String codeAppreciation) {
		this.codeAppreciation = codeAppreciation;
	}

	/**
	 * @return la liste des pr�sentations.
	 */
	protected List<Presentation> getPresentationsInternal() {
		if (this.presentationsInternal == null) {
			presentationsInternal = new ArrayList<Presentation>();
		}
		return presentationsInternal;
	}

	/**
	 * D�finit la liste des pr�sentations.
	 * 
	 * @param presentationsInternal
	 *            une liste de pr�sentations.
	 */
	protected void setPresentationsInternal(
			List<Presentation> presentationsInternal) {
		this.presentationsInternal = presentationsInternal;
	}

	/**
	 * @return la liste des pr�sentations.
	 */
	public List<Presentation> getPresentations() {
		return Collections.unmodifiableList(getPresentationsInternal());
	}

	/**
	 * Ajoute une pr�sentation.
	 * 
	 * @param presentation
	 *            une pr�sentation
	 * @return le r�sultat de l'ajout
	 */
	public boolean addPresentation(final Presentation presentation) {
		return this.getPresentationsInternal().add(presentation);
	}

	/**
	 * Suppression d'une pr�sentation.
	 * 
	 * @param presentation
	 *            une pr�sentation
	 * @return le r�sultat de la suppression d'une pr�sentation
	 */
	public boolean removePresentation(final Presentation presentation) {
		return this.getPresentationsInternal().remove(presentation);
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codeAppreciation).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Appreciation)) {
			return false;
		}

		final Appreciation other = (Appreciation) obj;

		return new EqualsBuilder().append(codeAppreciation,
				other.getCodeAppreciation()).isEquals();
	}

}
