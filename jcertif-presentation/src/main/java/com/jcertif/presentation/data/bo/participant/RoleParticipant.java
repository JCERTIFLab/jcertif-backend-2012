package com.jcertif.presentation.data.bo.participant;

import java.util.HashSet;
import java.util.Set;


import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.presentation.data.bo.AbstractBO;
import com.jcertif.presentation.data.bo.CodeDescription;

/**
 * @author chrisbel
 */
@XmlRootElement
public class RoleParticipant extends CodeDescription {

    private static final long serialVersionUID = 1L;
    /**
     * Mot cl� de la pr�sentation.*/
    private Set<Participant> participants = new HashSet<Participant>();

    /**
     * Constructor
     */
    public RoleParticipant() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor
     */
    public RoleParticipant(Long id, String code, String description) {
        super();
        this.setId(id);
        this.setCode(code);
        this.setDescription(description);
    }

    /**
     * @return the participantsTODO
     */
    public Set<Participant> getParticipants() {
        return participants;
    }

    /**
     * @param participants the participants to setTODOparticipants
     */
    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }
}
