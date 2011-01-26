package com.jcertif.presentation.data.bo.participant;


import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author rossi.oddet
 * 
 */

@XmlRootElement
public class TypeParticipant {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String code;

	private String description;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}	public TypeParticipant(String code, String desc) {
		this.setCode(code);
		this.setDescription(desc);
	}
}
