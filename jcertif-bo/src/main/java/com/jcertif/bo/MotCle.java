package com.jcertif.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * BO Mot clé.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
public class MotCle {

	/**
	 * Identifiant du mot clé.
	 */
	@Id
	@GeneratedValue
	@Column
	private Long id;

	/**
	 * Un mot clé.
	 */
	@Column
	private String motCle;

	/**
	 * Description d'un mot clé.
	 */
	@Column
	private String description;

	public Long getId() {
		return id;
	}

	/**
	 * Définit un identifiant.
	 * 
	 * @param id
	 *            un identifiant
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return un mot clé.
	 */
	public String getMotCle() {
		return motCle;
	}

	/**
	 * Définit un mot clé.
	 * 
	 * @param motCle
	 *            un mot clé
	 */
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	/**
	 * @return une description du mot clé.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Définit la description du mot clé.
	 * 
	 * @param description
	 *            une description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
