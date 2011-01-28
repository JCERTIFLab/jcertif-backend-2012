package com.jcertif.presentation.data.bo.participant;


import javax.xml.bind.annotation.XmlRootElement;

import com.jcertif.presentation.data.bo.CodeDescription;


/**
 * @author rossi.oddet
 * 
 */

@XmlRootElement
public class TypeParticipant extends CodeDescription {

	private static final long serialVersionUID = 1L;

	

	public TypeParticipant() {
		super();
		
	}



	public TypeParticipant(String code, String desc) {
		this.setCode(code);
		this.setDescription(desc);
	}
}
