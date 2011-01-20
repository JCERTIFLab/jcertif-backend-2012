package com.jcertif.bo.cedule;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import com.jcertif.bo.CodeDescription;

/**
 * BO Type �v�nement.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
@XmlRootElement
public class TypeEvenement extends CodeDescription {

	private static final long serialVersionUID = 1L;

	/**
	 * Un constructeur.
	 */
	public TypeEvenement() {
		super();
	}

	/**
	 * Un constructeur.
	 * 
	 * @param code
	 *            un code
	 * @param desc
	 *            une description
	 */
	public TypeEvenement(String code, String desc) {
		this.setCode(code);
		this.setDescription(desc);
	}
}