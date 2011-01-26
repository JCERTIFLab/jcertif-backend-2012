package com.jcertif.presentation.data.bo.comite;



import java.util.HashSet;
import java.util.Set;


import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;



/**
 * Un comit� d'organisation.
 * 
 * @author rossi.oddet
 * 
 */
@XmlRootElement
public class ComiteOrganisation{

	private static final long serialVersionUID = 1L;

	/**
	 * Identifiant d'un comit� d'organisation.
	 */

	private Long id;

	/**
	 * Le nom.
	 */

	private String nom;

	/**
	 * Le pr�nom.
	 */

	private String prenom;

	/**
	 * Le sexe.
	 */

	private Character sexeMf;

	/**
	 * L'email.
	 */

	private String email;

	/**
	 * Le t�l�phone.
	 */

	private String telephone;

	/**
	 * Les d�tails.
	 */

	private String details;


	private Set<ComiteRevisionPresentation> comiteRevisionPresentationsInternal;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the sexeMf
	 */
	public Character getSexeMf() {
		return sexeMf;
	}

	/**
	 * @param sexeMf
	 *            the sexeMf to set
	 */
	public void setSexeMf(Character sexeMf) {
		this.sexeMf = sexeMf;
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
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	 * @return the comiteRevisionPresentationsInternal
	 */
	protected Set<ComiteRevisionPresentation> getComiteRevisionPresentationsInternal() {
		if (comiteRevisionPresentationsInternal == null) {
			comiteRevisionPresentationsInternal = new HashSet<ComiteRevisionPresentation>();
		}
		return comiteRevisionPresentationsInternal;
	}

	/**
	 * @param comiteRevisionPresentationsInternal
	 *            the comiteRevisionPresentationsInternal to set
	 */
	protected void setComiteRevisionPresentationsInternal(
			Set<ComiteRevisionPresentation> comiteRevisionPresentationsInternal) {
		this.comiteRevisionPresentationsInternal = comiteRevisionPresentationsInternal;
	}

	/**
	 * @return la liste des comit�s r�vision.
	 */
	public Set<ComiteRevisionPresentation> getComiteRevisionPresentations() {
		return comiteRevisionPresentationsInternal;
	}

	/**
	 * Ajoute un comit� de r�vision.
	 * 
	 * @param comite
	 *            un comit� de r�vision
	 * @return le r�sultat de la suppression.
	 */
	public boolean addComiteRevisionPresentation(
			ComiteRevisionPresentation comite) {
		return getComiteRevisionPresentationsInternal().add(comite);
	}

	/**
	 * Supprime un comit� de r�vision.
	 * 
	 * @param comite
	 * @return le r�sultat de la suppression
	 */
	public boolean removeComiteRevisionPresentation(
			ComiteRevisionPresentation comite) {
		return getComiteRevisionPresentationsInternal().remove(comite);
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(nom).append(prenom).append(email)
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ComiteOrganisation)) {
			return false;
		}

		final ComiteOrganisation other = (ComiteOrganisation) obj;

		return new EqualsBuilder().append(nom, other.getNom())
				.append(prenom, other.getPrenom())
				.append(email, other.getEmail()).isEquals();
	} 

}