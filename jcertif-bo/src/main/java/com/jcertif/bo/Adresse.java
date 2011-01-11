package com.jcertif.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	 * @param code_postal
	 * @param ville
	 * @param province
	 * @param pays
	 * @param details
	 * @param telephone_fixe
	 * @param telephone_mobile
	 * @param fax
	 */
	public Adresse(Long id, String ligne1, String ligne2, String code_postal,
			String ville, String province, String pays, String details,
			String telephone_fixe, String telephone_mobile, String fax) {
		super();
		this.id = id;
		this.ligne1 = ligne1;
		this.ligne2 = ligne2;
		this.code_postal = code_postal;
		this.ville = ville;
		this.province = province;
		this.pays = pays;
		this.details = details;
		this.telephone_fixe = telephone_fixe;
		this.telephone_mobile = telephone_mobile;
		this.fax = fax;
	}

	@Column
	private String ligne1;
	@Column
	private String ligne2;
	@Column
	private String code_postal;
	@Column
	private String ville;
	@Column
	private String province;
	@Column
	private String pays;
	@Column
	private String details;
	@Column
	private String telephone_fixe;
	@Column
	private String telephone_mobile;
	@Column
	private String fax;
	
	
	
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
	 * Get the value of telephone_mobile
	 * 
	 * @return the value of telephone_mobile
	 */
	public String getTelephone_mobile() {
		return telephone_mobile;
	}

	/**
	 * Set the value of telephone_mobile
	 * 
	 * @param telephone_mobile
	 *            new value of telephone_mobile
	 */
	public void setTelephone_mobile(String telephone_mobile) {
		this.telephone_mobile = telephone_mobile;
	}

	/**
	 * Get the value of telephone_fixe
	 * 
	 * @return the value of telephone_fixe
	 */
	public String getTelephone_fixe() {
		return telephone_fixe;
	}

	/**
	 * Set the value of telephone_fixe
	 * 
	 * @param telephone_fixe
	 *            new value of telephone_fixe
	 */
	public void setTelephone_fixe(String telephone_fixe) {
		this.telephone_fixe = telephone_fixe;
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
	 * Get the value of code_postal
	 * 
	 * @return the value of code_postal
	 */
	public String getCode_postal() {
		return code_postal;
	}

	/**
	 * Set the value of code_postal
	 * 
	 * @param code_postal
	 *            new value of code_postal
	 */
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
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