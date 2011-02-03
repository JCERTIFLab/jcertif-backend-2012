package com.jcertif.presentation.data.bo.salle;

import java.util.HashSet;
import java.util.Set;


import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.presentation.data.bo.CodeDescription;

/**
 * @author chrisbel
 */
@XmlRootElement
public class ParticulariteSalle extends CodeDescription {

    private static final long serialVersionUID = 1L;
    
    private Set<Salle> salles = new HashSet<Salle>();

    /**
     * Constructor
     */
    public ParticulariteSalle() {
    }

    /**
     * Constructor
     */
    public ParticulariteSalle(Long id, String code, String description) {
        super();
        this.setId(id);
        this.setCode(code);
        this.setDescription(description);
    }

   
    /**
     * @return the sallesTODO
     */
    public Set<Salle> getSalles() {
        return salles;
    }

    /**
     * @param salles the salles to setTODOsalles
     */
    public void setSalles(Set<Salle> salles) {
        this.salles = salles;
    }
}
