package com.jcertif.presentation.data.bo.presentation;


import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.presentation.data.bo.AbstractBO;



/**
 * BO Mot cl�.
 * 
 * @author rossi.oddet
 * 
 */

@XmlRootElement
public class MotCle extends AbstractBO{

	private static final long serialVersionUID = 1L;

	/**
	 * Identifiant du mot cl�.
	 */

	private Long id;

	/**
	 * Un mot cl�.
	 */
	
	private String motCle;

	/**
	 * Description d'un mot cl�.
	 */
	
	private String description;

	/**
	 * Le constructeur par d�faut.
	 */
	public MotCle() {
		super();
	}

	/**
	 * Un constructeur.
	 * 
	 * @param motCle
	 *            un mot cl�
	 * @param description
	 *            une description
	 */
	public MotCle(final String motCle, final String description) {
		super();
		this.motCle = motCle;
		this.description = description;
	}

	/**
	 * @return l'identifiant d'un mot cl�.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * D�finit un identifiant.
	 * 
	 * @param id
	 *            un identifiant
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return un mot cl�.
	 */
	public String getMotCle() {
		return motCle;
	}

	/**
	 * D�finit un mot cl�.
	 * 
	 * @param motCle
	 *            un mot cl�
	 */
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	/**
	 * @return une description du mot cl�.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * D�finit la description du mot cl�.
	 * 
	 * @param description
	 *            une description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	 
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(motCle).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MotCle)) {
			return false;
		}

		final MotCle other = (MotCle) obj;

		return new EqualsBuilder().append(motCle, other.getMotCle()).isEquals();
	}

}
