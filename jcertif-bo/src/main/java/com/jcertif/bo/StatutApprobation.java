package com.jcertif.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * BO Statut approbation.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
public class StatutApprobation {

	/**
	 * Identifiant d'un statut d'approbation.
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Un code de statut.
	 */
	@Column
	private String codeStatut;

	/**
	 * Une description du statut d'approbation.
	 */
	@Column
	private String description;

	/**
	 * @return l'identifiant d'un statut d'approbation
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Définit l'identifiant d'un statut d'approbation
	 * 
	 * @param id
	 *            un identifiant
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return le code statut
	 */
	public String getCodeStatut() {
		return codeStatut;
	}

	/**
	 * Définit le code statut.
	 * 
	 * @param codeStatut
	 *            un code statut
	 */
	public void setCodeStatut(String codeStatut) {
		this.codeStatut = codeStatut;
	}

	/**
	 * @return une description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Définit une description.
	 * 
	 * @param description
	 *            une description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
