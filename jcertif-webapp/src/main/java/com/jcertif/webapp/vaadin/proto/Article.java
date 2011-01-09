package com.jcertif.webapp.vaadin.proto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Article Business Object.
 * 
 * @author rossi.oddet
 * 
 */
@XmlRootElement
public class Article {

	/**
	 * Identifiant.
	 */
	private Long id;

	/**
	 * A title.
	 */
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
