package com.jcertif.bo.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Article Business Object.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
public class Article {

	/**
	 * Identifiant.
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * A title.
	 */
	@Column
	private String title;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

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
}
