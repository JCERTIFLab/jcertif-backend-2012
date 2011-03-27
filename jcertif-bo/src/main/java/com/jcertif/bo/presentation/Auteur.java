/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.bo.presentation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.bo.Person;

/**
 * BO Auteur.
 * 
 * @author rossi.oddet
 */
@Entity
@XmlRootElement
public class Auteur extends Person {

	private static final long serialVersionUID = 1L;
	@Column
	private String biographieSommaire;
	@Column
	private String photo;

	
	/**
	 * @return the biographieSommaire
	 */
	public String getBiographieSommaire() {
		return biographieSommaire;
	}

	/**
	 * @param biographieSommaire the biographieSommaire to set
	 */
	public void setBiographieSommaire(String biographieSommaire) {
		this.biographieSommaire = biographieSommaire;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getEmail()).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Auteur)) {
			return false;
		}

		final Auteur other = (Auteur) obj;

		return new EqualsBuilder().append(this.getNom(), other.getNom())
				.append(this.getPrenom(), other.getPrenom())
				.append(this.getEmail(), other.getEmail()).isEquals();
	}

}
