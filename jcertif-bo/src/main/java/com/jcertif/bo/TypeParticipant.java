package com.jcertif.bo;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rossi.oddet
 * 
 */
@Entity
@XmlRootElement
public class TypeParticipant extends CodeDescription {

	private static final long serialVersionUID = 1L;

	/**
	 * Un constructeur.
	 */
	public TypeParticipant() {
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
	public TypeParticipant(String code, String desc) {
		this.setCode(code);
		this.setDescription(desc);
	}
}
