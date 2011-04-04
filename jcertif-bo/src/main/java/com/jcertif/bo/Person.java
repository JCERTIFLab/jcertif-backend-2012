package com.jcertif.bo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * Classe de base Personne.
 * 
 * @author Douneg
 */
@MappedSuperclass
public abstract class Person extends AbstractBO {

	private static final long serialVersionUID = 1L;

	/**
	 * Un constructeur.
	 */
	public Person() {
		super();
	}

	/**
	 * Identifiant d'une personne.
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Prénom d'une personne.
	 */
	@Column
	private String prenom;

	/**
	 * Nom d'une personne.
	 */
	@Column
	private String nom;

	/**
	 * Sexe de la personne.
	 */
	@Column(name = "sexe_MF")
	private Character sexe;

	/**
	 * Salutation de la personne.
	 */
	@Column
	private String salutation;

	/**
	 * Specialité de la personne.
	 */
	@Column
	private String specialite;

	/**
	 * Adresse de la personne.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "adresse_id")
	private Adresse adresse;

	/**
	 * Détails de la personne.
	 */
	@Column (length=1000)
	private String details;

	/**
	 * Email de la personne.
	 */
	@Column
	private String email;
	
	/**
	 * Site web d'une personne.
	 */
	@Column
	private String website;

	/**
	 * fournit l'ID de l'individu
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * modifie l'ID de l'individu
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * fournit le nom
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * modifie le nom
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * fournit le prenom
	 * 
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * modifie le prenom
	 * 
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the sexe
	 */
	public Character getSexe() {
		return sexe;
	}

	/**
	 * @param sexe
	 *            the sexe to set
	 */
	public void setSexe(Character sexe) {
		this.sexe = sexe;
	}

	/**
	 * @return the salutation
	 */
	public String getSalutation() {
		return salutation;
	}

	/**
	 * @param salutation
	 *            the salutation to set
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
	 * @param specialite
	 *            the specialite to set
	 */
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
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
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	
	

}
