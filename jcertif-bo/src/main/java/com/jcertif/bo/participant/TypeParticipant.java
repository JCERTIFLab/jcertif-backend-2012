package com.jcertif.bo.participant;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jcertif.bo.CodeDescription;

/**
 * @author rossi.oddet
 * 
 */
@Entity
@XmlRootElement
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
