package com.jcertif.presentation.data.bo.presentation;

import javax.xml.bind.annotation.XmlRootElement;


import com.jcertif.presentation.data.bo.CodeDescription;

/**
 * BO Statut approbation.
 * 
 * @author rossi.oddet
 * 
 */
@XmlRootElement
public class StatutApprobation extends CodeDescription {

    private static final long serialVersionUID = 1L;

    /**
     * Un constructeur.
     */
    public StatutApprobation() {
        super();
    }

    /**
     * Un constructeur.
     *
     * @param code
     *            un code statut
     * @param description
     *            une description
     */
    public StatutApprobation(String code, String description) {
        super();
        this.setCode(code);
        this.setDescription(description);
    }
}
