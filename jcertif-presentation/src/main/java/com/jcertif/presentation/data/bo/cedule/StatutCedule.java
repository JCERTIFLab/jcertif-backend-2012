package com.jcertif.presentation.data.bo.cedule;


import javax.xml.bind.annotation.XmlRootElement;

import com.jcertif.presentation.data.bo.CodeDescription;



/**
 * BO Statut Cedule.
 * 
 * @author rossi.oddet
 * 
 */

@XmlRootElement
public class StatutCedule extends CodeDescription {

	private static final long serialVersionUID = 1L;

	
	public StatutCedule() {
		super();
		
	}


	public StatutCedule(String code, String description) {
		super();
		this.setCode(code);
		this.setDescription(description);
	}

}
