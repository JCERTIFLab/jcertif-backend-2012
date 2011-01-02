/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.bo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author chrisbel
 */
public class ParticulariteSalle {

	private Long id;
	private String code;
	private String description;

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

}
