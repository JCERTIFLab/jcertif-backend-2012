package com.jcertif.presentation.data.bo.salle;



import java.util.HashSet;
import java.util.Set;


import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;



/**
 * @author chrisbel
 */

@XmlRootElement
public class ParticulariteSalle {

	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private String code;
	
	private String description;
	
	
	private Set<Salle> salles=new HashSet<Salle>();

	/**
	 * Constructor
	 */
	public ParticulariteSalle() {

	}

	/**
	 * Constructor
	 */
	public ParticulariteSalle(Long id, String code, String description) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
	}

	/**
	 * @return the idTODO
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to setTODOid
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the codeTODO
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to setTODOcode
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the descriptionTODO
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to setTODOdescription
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	
	@Override
		public int hashCode() {
		return new HashCodeBuilder().append(id).append(code)
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

		if (!(obj instanceof ParticulariteSalle)) {
			return false;
		}

		final ParticulariteSalle other = (ParticulariteSalle) obj;

		return new EqualsBuilder().append(id, other.getId()).append(code, other.getCode()).isEquals();
	} 

	/**
	 * @return the sallesTODO
	 */
	public Set<Salle> getSalles() {
		return salles;
	}

	/**
	 * @param salles the salles to setTODOsalles
	 */
	public void setSalles(Set<Salle> salles) {
		this.salles = salles;
	}

}
