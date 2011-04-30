package com.jcertif.bo.participant;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jcertif.bo.CodeDescription;

/**
 * Niveau de partenariat.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
@XmlRootElement
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class NiveauPartenariat extends CodeDescription {

	private static final long serialVersionUID = 1L;

}
