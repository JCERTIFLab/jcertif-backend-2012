package com.jcertif.bo.cedule;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import com.jcertif.bo.CodeDescription;

/**
 * BO Statut Cedule.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
@XmlRootElement
public class StatutCedule extends CodeDescription {

	private static final long serialVersionUID = 1L;

	/**
	 * Un constructeur.
	 */
	public StatutCedule() {
		super();
	}

	/**
	 * Un constructeur.
	 * 
	 * @param code
	 *            un code
	 * @param description
	 *            une description
	 */
	public StatutCedule(String code, String description) {
		super();
		this.setCode(code);
		this.setDescription(description);
	}

}
