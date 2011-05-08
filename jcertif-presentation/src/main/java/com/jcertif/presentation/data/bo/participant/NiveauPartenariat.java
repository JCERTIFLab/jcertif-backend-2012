package com.jcertif.presentation.data.bo.participant;

import com.jcertif.presentation.data.bo.CodeDescription;

/**
 * Niveau de partenariat.
 * 
 * @author rossi.oddet
 * 
 */
public class NiveauPartenariat extends CodeDescription implements
		Comparable<NiveauPartenariat> {

	private static final long serialVersionUID = 1L;

	@Override
	public int compareTo(NiveauPartenariat o) {
		return this.getId().compareTo(o.getId());
	}

}
