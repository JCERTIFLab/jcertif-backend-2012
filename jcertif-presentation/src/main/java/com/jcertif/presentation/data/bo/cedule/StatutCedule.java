package com.jcertif.presentation.data.bo.cedule;


import javax.xml.bind.annotation.XmlRootElement;



/**
 * BO Statut Cedule.
 * 
 * @author rossi.oddet
 * 
 */

@XmlRootElement
public class StatutCedule  {

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
	}

	public StatutCedule(String code, String description) {
		super();
		this.setCode(code);
		this.setDescription(description);
	}

}
