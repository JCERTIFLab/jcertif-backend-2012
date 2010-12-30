package com.jcertif.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * BO Mot cl�.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
public class MotCle {

	/**
	 * Identifiant du mot cl�.
	 */
	@Id
	@GeneratedValue
	@Column
	private Long id;

	/**
	 * Un mot cl�.
	 */
	@Column
	private String motCle;

	/**
	 * Description d'un mot cl�.
	 */
	@Column
	private String description;

	public Long getId() {
		return id;
	}

	/**
	 * D�finit un identifiant.
	 * 
	 * @param id
	 *            un identifiant
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return un mot cl�.
	 */
	public String getMotCle() {
		return motCle;
	}

	/**
	 * D�finit un mot cl�.
	 * 
	 * @param motCle
	 *            un mot cl�
	 */
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	/**
	 * @return une description du mot cl�.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * D�finit la description du mot cl�.
	 * 
	 * @param description
	 *            une description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
