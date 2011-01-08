/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcertif.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Douneg
 */
@Entity
public class PresentationAuteur implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected PresentationAuteurPK presentationAuteurPK;
	@ManyToOne(optional = false)
	@Column
	protected Auteur auteur_id;
	@ManyToOne(optional = false)
	@Column
	protected Presentation presentation_id;

	public PresentationAuteurPK getPresentationAuteurPK() {
		return presentationAuteurPK;
	}

	public PresentationAuteur(PresentationAuteurPK presentationAuteurPK) {
		super();
		this.presentationAuteurPK = presentationAuteurPK;
	}

	public PresentationAuteur(Auteur auteur_id, Presentation presentation_id) {
		super();
		this.presentationAuteurPK = new PresentationAuteurPK(auteur_id.getId(),
				presentation_id.getId());
		this.auteur_id = auteur_id;
		this.presentation_id = presentation_id;
	}

	/**
	 * @return the auteur_id
	 */
	public Auteur getAuteur_id() {
		return auteur_id;
	}

	/**
	 * @param auteur_id
	 *            the auteur_id to set
	 */
	public void setAuteur_id(Auteur auteur_id) {
		this.auteur_id = auteur_id;
	}

	/**
	 * @return the presentation_id
	 */
	public Presentation getPresentation_id() {
		return presentation_id;
	}

	/**
	 * @param presentation_id
	 *            the presentation_id to set
	 */
	public void setPresentation_id(Presentation presentation_id) {
		this.presentation_id = presentation_id;
	}

	/**
	 * @param presentationAuteurPK
	 *            the presentationAuteurPK to set
	 */
	public void setPresentationAuteurPK(
			PresentationAuteurPK presentationAuteurPK) {
		this.presentationAuteurPK = presentationAuteurPK;
	}

}
