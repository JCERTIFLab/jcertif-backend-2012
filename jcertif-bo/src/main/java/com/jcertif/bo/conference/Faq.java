/**
 * 
 */
package com.jcertif.bo.conference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.bo.AbstractBO;

/**
 * @author rossi
 * 
 */
@Entity
@XmlRootElement
public class Faq extends AbstractBO {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String question;

	@Column
	private String reponse;

	@Column(name="conference_id")
	private Long conferenceId;

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
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the reponse
	 */
	public String getReponse() {
		return reponse;
	}

	/**
	 * @param reponse
	 *            the reponse to set
	 */
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
	
	

	/**
	 * @return the conferenceId
	 */
	public Long getConferenceId() {
		return conferenceId;
	}

	/**
	 * @param conferenceId the conferenceId to set
	 */
	public void setConferenceId(Long conferenceId) {
		this.conferenceId = conferenceId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Faq)) {
			return false;
		}

		final Faq other = (Faq) obj;

		return new EqualsBuilder().append(this.getId(), other.getId()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId()).toHashCode();
	}

}
