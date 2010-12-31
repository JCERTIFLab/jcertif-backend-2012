/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.bo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;

/**
 *
 * @author Douneg
 */
@Embeddable
public class PresentationAuteurPK implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    protected long auteur_id;
    @Basic(optional = false)
    protected long presentation_id;

    /**
     * Get the value of presentation_id
     *
     * @return the value of presentation_id
     */
    public long getPresentation_id() {
        return presentation_id;
    }

    /**
     * Set the value of presentation_id
     *
     * @param presentation_id new value of presentation_id
     */
    public void setPresentation_id(long presentation_id) {
        this.presentation_id = presentation_id;
    }

    /**
     * Get the value of auteur_id
     *
     * @return the value of auteur_id
     */
    public long getAuteur_id() {
        return auteur_id;
    }

    /**
     * Set the value of auteur_id
     *
     * @param auteur_id new value of auteur_id
     */
    public void setAuteur_id(long auteur_id) {
        this.auteur_id = auteur_id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PresentationAuteurPK other = (PresentationAuteurPK) obj;
        if (this.auteur_id != other.auteur_id) {
            return false;
        }
        if (this.presentation_id != other.presentation_id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.auteur_id ^ (this.auteur_id >>> 32));
        hash = 97 * hash + (int) (this.presentation_id ^ (this.presentation_id >>> 32));
        return hash;
    }
}
