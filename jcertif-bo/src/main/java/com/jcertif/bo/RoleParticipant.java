/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author chrisbel
 */
@Entity
@XmlRootElement
public class RoleParticipant extends AbstractBO {

	private static final long serialVersionUID = 1L;

	/**
	 * Identifiant du mot cl�.
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String codeRole;
	@Column
	private String description;
	/**
	 * Mot cl� de la pr�sentation.
	 */
	@OneToMany
	@JoinColumn(name ="role_participant_id")
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
	
	public String toXML(){
		StringBuilder xml = new StringBuilder();
		xml.append("<roleparticipant>");
		xml.append("<id>").append(id).append("</id>");
		xml.append("<codeRole>").append(codeRole).append("</codeRole>");
		xml.append("<description>").append(description).append("</description>");
		xml.append("<link>").append(getLink()).append("</link>");
		xml.append("</roleparticipant>");
		
		return xml.toString();
	}
	
	private String getLink() {
		return "/roleparticipant/" + codeRole;
	}
	
	public String toJSON() {
		StringBuilder json = new StringBuilder();
		json.append("{\"participant\":{\"id\":\"").append(id)
		.append("\", \"codeRole\":\"").append(codeRole)
		.append("\", \"description\":\"").append(description)
		.append("\", \"participants\":\"")
		
		.append("\", \"link\":\"").append(getLink()).append("\"}}");
		
		return json.toString();
	}
	
}
