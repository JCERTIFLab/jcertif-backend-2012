/**
 * 
 */
package com.jcertif.facade.model.participant;

import com.jcertif.bo.participant.Participant;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author mamadou
 * 
 */
@XmlRootElement
public class User {

	private Long id;
	private String civilite;
	private String nom;
	private String prenom;
	private String email;
	private String passwd;
	private String role;
	private String typeUser;
	private String compagnie;
	private String siteWeb;
	private String telFixe;
	private String telMobile;
	private String ville;
	private String pays;

	public User() {
		super();
	}

	public User(Participant part) {
		this.id 		= part.id;
		this.civilite 	= part.getSalutation();
		this.prenom 	= part.getPrenom();
		this.nom 		= part.getNom();
		this.siteWeb 	= part.getWebsite();
		this.compagnie 	= part.getCompagnie();
		this.passwd 	= part.getProfilUtilisateur().getPassword();
		this.role 		= part.getRoleparticipant().getCode();
		this.typeUser 	= part.getTypeParticipant().getCode();
		this.telFixe 	= part.getAdresse().getTelephoneFixe();
		this.telMobile 	= part.getAdresse().getTelephoneMobile();
		this.ville 		= part.getAdresse().getVille();
		this.pays 		= part.getAdresse().getPays();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public String getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public String getTelFixe() {
		return telFixe;
	}

	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}

	public String getTelMobile() {
		return telMobile;
	}

	public void setTelMobile(String telMobile) {
		this.telMobile = telMobile;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

}
