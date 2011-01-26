package com.jcertif.presentation.data.bo.cedule;


import javax.xml.bind.annotation.XmlRootElement;


/**
 * BO Type évènement.
 * 
 * @author rossi.oddet
 * 
 */

@XmlRootElement
public class TypeEvenement {

	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * Code du statut cedule.
	 */
	private String code;

	/**
	 * Description du statut cedule.
	 */
	private String description;



	public Long getId() {
		return id;
	}

	/**
	 * Définit un identifiant du statut cedule.
	 * 
	 * @param id
	 *            un identifiant
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return le code du statut cedule.
	 */

	public String getCode() {
		return code;
	}

	/**
	 * Définit le code de statut cedule.
	 * 
	 * @param code
	 *            un code de statut cedule
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return la description du statut cedule
	 */

	public String getDescription() {
		return description;
	}

	/**
	 * Définit la description du statut cedule.
	 * 
	 * @param description
	 *            une description du statut cedule.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public TypeEvenement(String code, String desc) {
		this.setCode(code);
		this.setDescription(desc);
	}

	public TypeEvenement() {
		
	}
	
	
}
