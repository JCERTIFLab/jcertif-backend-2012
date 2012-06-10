package com.jcertif.bo.presentation;

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

import com.jcertif.bo.AbstractBO;

/**
 * BO Appreciation.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
@XmlRootElement
public class Appreciation extends AbstractBO {

	private static final long serialVersionUID = 1L;

	/**
	 * Identifiant d'une appreciation.
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Le code de l'appreciation.
	 */
	@Column(nullable = false)
	private String codeAppreciation;

	/**
	 * La description de l'appreciation.
	 */
	@Column
	private String description;

	/**
	 * Liste de présentations.
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "appreciation_presentation", joinColumns = @JoinColumn(name = "appreciation_id"), inverseJoinColumns = @JoinColumn(name = "proposition_presentation_id"))
	private List<PropositionPresentation> presentationsInternal;

	/**
	 * Constructeur par défaut.
	 */
	public Appreciation() {
		super();
	}

	/**
	 * Un constructeur.
	 * 
	 * @param codeAppreciation
	 *            un code appréciation
	 * @param description
	 *            une description
	 */
	public Appreciation(String codeAppreciation, String description) {
		super();
		this.codeAppreciation = codeAppreciation;
		this.description = description;
	}

	/**
	 * @return l'identifiant de l'appréciation.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Definit l'identifiant de l'appréciation.
	 * 
	 * @param id
	 *            un identifiant
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return la description de l'appréciation.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Definit une description de l'appréciation.
	 * 
	 * @param description
	 *            une description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return le code de l'appréciation
	 */
	public String getCodeAppreciation() {
		return codeAppreciation;
	}

	/**
	 * Definit le code de l'appréciation.
	 * 
	 * @param codeAppreciation
	 *            un code d'appréciation
	 */
	public void setCodeAppreciation(String codeAppreciation) {
		this.codeAppreciation = codeAppreciation;
	}

	/**
	 * @return la liste des présentations.
	 */
	protected List<PropositionPresentation> getPresentationsInternal() {
		if (this.presentationsInternal == null) {
			presentationsInternal = new ArrayList<PropositionPresentation>();
		}
		return presentationsInternal;
	}

	/**
	 * Definit la liste des présentations.
	 * 
	 * @param presentationsInternal
	 *            une liste de présentations.
	 */
	protected void setPresentationsInternal(
			List<PropositionPresentation> presentationsInternal) {
		this.presentationsInternal = presentationsInternal;
	}

	/**
	 * @return la liste des présentations.
	 */
	public List<PropositionPresentation> getPresentations() {
		return Collections.unmodifiableList(getPresentationsInternal());
	}

	/**
	 * Ajoute une présentation.
	 * 
	 * @param presentation
	 *            une présentation
	 * @return le résultat de l'ajout
	 */
	public boolean addPresentation(final PropositionPresentation presentation) {
		return this.getPresentationsInternal().add(presentation);
	}

	/**
	 * Suppression d'une présentation.
	 * 
	 * @param presentation
	 *            une présentation
	 * @return le résultat de la suppression d'une presentation
	 */
	public boolean removePresentation(final PropositionPresentation presentation) {
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
