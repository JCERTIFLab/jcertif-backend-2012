package com.jcertif.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 
 * @author Douneg
 */
@Entity
@XmlRootElement
public class Adresse extends AbstractBO {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String ligne1;
	@Column
	private String ligne2;
	@Column
	private String codePostal;
	@Column
	private String ville;
	@Column
	private String province;
	@Column
	private String pays;
	@Column
	private String details;
	@Column
	private String telephoneFixe;
	@Column
	private String telephoneMobile;
	@Column
	private String fax;
	
	/**
	 * 
	 */
	public Adresse() {
		super();
	}

	/**
	 * @param id
	 * @param ligne1
	 * @param ligne2
	 * @param codePostal
	 * @param ville
	 * @param province
	 * @param pays
	 * @param details
	 * @param telephoneFixe
	 * @param telephoneMobile
	 * @param fax
	 */
	public Adresse(Long id, String ligne1, String ligne2, String codePostal,
			String ville, String province, String pays, String details,
			String telephoneFixe, String telephoneMobile, String fax) {
		super();
		this.id = id;
		this.ligne1 = ligne1;
		this.ligne2 = ligne2;
		this.codePostal = codePostal;
		this.ville = ville;
		this.province = province;
		this.pays = pays;
		this.details = details;
		this.telephoneFixe = telephoneFixe;
		this.telephoneMobile = telephoneMobile;
		this.fax = fax;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	/**
	 * Get the value of fax
	 * 
	 * @return the value of fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * Set the value of fax
	 * 
	 * @param fax
	 *            new value of fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	

	/**
	 * Get the value of details
	 * 
	 * @return the value of details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * Set the value of details
	 * 
	 * @param details
	 *            new value of details
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * Get the value of pays
	 * 
	 * @return the value of pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * Set the value of pays
	 * 
	 * @param pays
	 *            new value of pays
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * Get the value of province
	 * 
	 * @return the value of province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * Set the value of province
	 * 
	 * @param province
	 *            new value of province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * Get the value of ville
	 * 
	 * @return the value of ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Set the value of ville
	 * 
	 * @param ville
	 *            new value of ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	

	/**
	 * Get the value of ligne2
	 * 
	 * @return the value of ligne2
	 */
	public String getLigne2() {
		return ligne2;
	}

	/**
	 * Set the value of ligne2
	 * 
	 * @param ligne2
	 *            new value of ligne2
	 */
	public void setLigne2(String ligne2) {
		this.ligne2 = ligne2;
	}

	/**
	 * Get the value of ligne1
	 * 
	 * @return the value of ligne1
	 */
	public String getLigne1() {
		return ligne1;
	}

	/**
	 * Set the value of ligne1
	 * 
	 * @param ligne1
	 *            new value of ligne1
	 */
	public void setLigne1(String ligne1) {
		this.ligne1 = ligne1;
	}
	
	
	

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the telephoneFixe
	 */
	public String getTelephoneFixe() {
		return telephoneFixe;
	}

	/**
	 * @param telephoneFixe the telephoneFixe to set
	 */
	public void setTelephoneFixe(String telephoneFixe) {
		this.telephoneFixe = telephoneFixe;
	}

	/**
	 * @return the telephoneMobile
	 */
	public String getTelephoneMobile() {
		return telephoneMobile;
	}

	/**
	 * @param telephoneMobile the telephoneMobile to set
	 */
	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Adresse)) {
			return false;
		}

		final Adresse other = (Adresse) obj;

		return new EqualsBuilder().append(id,
				other.getId()).isEquals();
	}


}