package com.jcertif.bo;

import java.io.Serializable;

/**
 * Classe more de tous les BO. Le but est de créer des contraintes sur les BO.
 * 
 * @author rossi.oddet
 * 
 */
public abstract class AbstractBO implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean equals(Object obj);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract int hashCode();

}
