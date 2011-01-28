package com.jcertif.presentation.data.bo.presentation;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.presentation.data.bo.AbstractBO;



/**
 * BO Appreciation.
 * 
 * @author rossi.oddet
 * 
 */

@XmlRootElement
public class Appreciation extends AbstractBO {

	private static final long serialVersionUID = 1L;

	/**
	 * Identifiant d'une appreciation.
	 */

	private Long id;

	/**
	 * Le code de l'appr�ciation.
	 */

	private String codeAppreciation;

	/**
	 * La description de l'appreciation.
	 */

	private String description;

	/**
	 * Liste de pr�sentations.
	 */
	
	private List<PropositionPresentation> presentationsInternal;

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
	protected List<PropositionPresentation> getPresentationsInternal() {
		if (this.presentationsInternal == null) {
			presentationsInternal = new ArrayList<PropositionPresentation>();
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
			List<PropositionPresentation> presentationsInternal) {
		this.presentationsInternal = presentationsInternal;
	}

	/**
	 * @return la liste des pr�sentations.
	 */
	public List<PropositionPresentation> getPresentations() {
		return Collections.unmodifiableList(getPresentationsInternal());
	}

	/**
	 * Ajoute une pr�sentation.
	 * 
	 * @param presentation
	 *            une pr�sentation
	 * @return le r�sultat de l'ajout
	 */
	public boolean addPresentation(final PropositionPresentation presentation) {
		return this.getPresentationsInternal().add(presentation);
	}

	/**
	 * Suppression d'une pr�sentation.
	 * 
	 * @param presentation
	 *            une pr�sentation
	 * @return le r�sultat de la suppression d'une pr�sentation
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
