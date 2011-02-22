/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.bo.participant;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;


import com.jcertif.bo.CodeDescription;

/**
 * @author chrisbel
 */
@Entity
@XmlRootElement
public class RoleParticipant extends CodeDescription {

    private static final long serialVersionUID = 1L;


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

}
