/**
 * 
 */
package com.jcertif.facade.model.participant;

import com.jcertif.bo.participant.User;
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
	private String pays ;

	public User(){
		super();
	}

	public User(User user) {
		this.id = user.id;
		this.civilite = user.civilite;
		this.nom = user.nom;
		this.prenom = user.prenom;
		this.email = user.email;
		this.passwd = user.passwd;
		this.role = user.role;
		this.typeUser = user.typeUser;
		this.compagnie = user.compagnie;
		this.siteWeb = user.siteWeb;
		this.telFixe = user.telFixe;
		this.telMobile = user.telMobile;
		this.ville = user.ville;
		this.pays = user.pays;
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
