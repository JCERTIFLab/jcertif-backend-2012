

package com.jcertif.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Douneg
 */
@MappedSuperclass
public class Person implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Person() {
    }
    @Id
    @GeneratedValue
    protected Long id;
    @Column
    protected String nom;
    @Column
    protected String prenom;
    @Column
    protected Character sexe_MF;
    @Column
    protected String telephone;
    @Column
    protected String salutation;
    @Column
    protected String specialite;
    @Column
    protected String adresse;
    @Column
    protected String details;
    @Column
    protected String email;

	/**
	 * fournit l'ID de l'individu
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * modifie l'ID de l'individu
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * fournit le nom
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * modifie le nom
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * fournit le prenom
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * modifie le prenom
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * founrit le sexe de l'individu
	 * @return the sexe_MF
	 */
	public Character getSexe_MF() {
		return sexe_MF;
	}
	/**
	 * modifie le sexe de l'individue
	 * @param sexe_MF the sexe_MF to set
	 */
	public void setSexe_MF(Character sexe_MF) {
		this.sexe_MF = sexe_MF;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the salutation
	 */
	public String getSalutation() {
		return salutation;
	}
	/**
	 * @param salutation the salutation to set
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	/**
	 * @return the specialite
	 */
	public String getSpecialite() {
		return specialite;
	}
	/**
	 * @param specialite the specialite to set
	 */
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

    
}
