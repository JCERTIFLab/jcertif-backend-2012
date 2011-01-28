package com.jcertif.presentation.data.bo.cedule;


import javax.xml.bind.annotation.XmlRootElement;

import com.jcertif.presentation.data.bo.CodeDescription;


/**
 * BO Type évènement.
 * 
 * @author rossi.oddet
 * 
 */

@XmlRootElement
public class TypeEvenement extends CodeDescription {

	private static final long serialVersionUID = 1L;

	public TypeEvenement() {
		super();
	}

	/**
	 * Définit la description du statut cedule.
	 * 
	 * @param description
	 *            une description du statut cedule.
	 */
	
	public TypeEvenement(String code, String desc) {
		this.setCode(code);
		this.setDescription(desc);
	}

	
	
	
}
