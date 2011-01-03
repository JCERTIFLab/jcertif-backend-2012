/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author chrisbel
 */
@Entity
public class RoleParticipant {

	/**
	 * Identifiant du mot clé.
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String codeRole;
	@Column
	private String description;
	/**
	 * Mot clé de la présentation.
	 */
	@OneToMany
	@JoinColumn(name ="particpant_id")
	private Set<Participant> participants=new HashSet<Participant>();
	
	
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


	/**
	 * @return the participantsTODO
	 */
	public Set<Participant> getParticipants() {
		return participants;
	}


	/**
	 * @param participants the participants to setTODOparticipants
	 */
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}
	
}
