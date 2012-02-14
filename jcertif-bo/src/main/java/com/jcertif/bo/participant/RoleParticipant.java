/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.bo.participant;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jcertif.bo.CodeDescription;

/**
 * @author chrisbel
 */
@Entity
@XmlRootElement
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RoleParticipant extends CodeDescription {

	private static final long serialVersionUID = 1L;

	public static final String CODE_SPEAKER = "Speaker";
	public static final String CODE_SPONSOR = "Partenaire";

	/**
	 * Constructor
	 */
	public RoleParticipant() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor
	 */
	public RoleParticipant(Long id, String code, String description) {
		super();
		this.setId(id);
		this.setCode(code);
		this.setDescription(description);
	}

}
