package com.jcertif.presentation.data.bo.presentation;


import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.presentation.data.bo.AbstractBO;



/**
 * BO Mot clé.
 * 
 * @author rossi.oddet
 * 
 */

@XmlRootElement
public class MotCle extends AbstractBO{

	private static final long serialVersionUID = 1L;

	/**
	 * Identifiant du mot clé.
	 */

	private Long id;

	/**
	 * Un mot clé.
	 */
	
	private String motCle;

	/**
	 * Description d'un mot clé.
	 */
	
	private String description;

	/**
	 * Le constructeur par défaut.
	 */
	public MotCle() {
		super();
	}

	/**
	 * Un constructeur.
	 * 
	 * @param motCle
	 *            un mot clé
	 * @param description
	 *            une description
	 */
	public MotCle(final String motCle, final String description) {
		super();
		this.motCle = motCle;
		this.description = description;
	}

	/**
	 * @return l'identifiant d'un mot clé.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Définit un identifiant.
	 * 
	 * @param id
	 *            un identifiant
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return un mot clé.
	 */
	public String getMotCle() {
		return motCle;
	}

	/**
	 * Définit un mot clé.
	 * 
	 * @param motCle
	 *            un mot clé
	 */
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	/**
	 * @return une description du mot clé.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Définit la description du mot clé.
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
