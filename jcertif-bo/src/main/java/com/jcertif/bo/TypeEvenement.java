package com.jcertif.bo;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * BO Type évènement.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
@XmlRootElement
public class TypeEvenement extends CodeDescription {

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
