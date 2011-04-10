package com.jcertif.presentation.ui.propositionPresentation;

import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;

/**
 * @author rossi
 * 
 */
public class PropositionPresentationBean extends PropositionPresentation {

	private static final long serialVersionUID = 1L;

	private HashSetStringFormVaadin sujetStringList;

	/**
	 * @return the sujetStringList
	 */
	public HashSetStringFormVaadin getSujetStringList() {
		return sujetStringList;
	}

	/**
	 * @param sujetStringList
	 *            the sujetStringList to set
	 */
	public void setSujetStringList(HashSetStringFormVaadin sujetStringList) {
		this.sujetStringList = sujetStringList;
	}

}
