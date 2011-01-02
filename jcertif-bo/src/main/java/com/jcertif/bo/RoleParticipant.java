/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.bo;

import javax.persistence.Column;
import javax.persistence.Id;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author chrisbel
 */
public class RoleParticipant {

	@Id
	private Long id;
	@Column
	private String codeRole;
	@Column
	private String description;
	
	
	/**
	 * Constructor
	 */
	public RoleParticipant() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * Constructor
	 */
	public RoleParticipant(Long id, String codeRole, String description) {
		super();
		this.id = id;
		this.codeRole = codeRole;
		this.description = description;
	}


	/**
	 * @return the idTODO
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to setTODOid
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the codeRoleTODO
	 */
	public String getCodeRole() {
		return codeRole;
	}


	/**
	 * @param codeRole the codeRole to setTODOcodeRole
	 */
	public void setCodeRole(String codeRole) {
		this.codeRole = codeRole;
	}


	/**
	 * @return the descriptionTODO
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to setTODOdescription
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(codeRole)
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

		if (!(obj instanceof RoleParticipant)) {
			return false;
		}

		final RoleParticipant other = (RoleParticipant) obj;

		return new EqualsBuilder().append(id, other.getId()).append(codeRole, other.getCodeRole()).isEquals();
	}
	
}
