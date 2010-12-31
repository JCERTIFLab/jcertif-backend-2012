/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.bo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Douneg
 */
@Entity
public class Participant extends Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Temporal(value = TemporalType.DATE)
    protected Date dataInscription;

    /**
     * Get the value of dataInscription
     *
     * @return the value of dataInscription
     */
    public Date getDataInscription() {
        return dataInscription;
    }
    protected byte[] presentation_soumise;

    /**
     * Get the value of presentation_soumise
     *
     * @return the value of presentation_soumise
     */
    public byte[] getPresentation_soumise() {
        return presentation_soumise;
    }

    /**
     * Set the value of presentation_soumise
     *
     * @param presentation_soumise new value of presentation_soumise
     */
    public void setPresentation_soumise(byte[] presentation_soumise) {
        this.presentation_soumise = presentation_soumise;
    }
    protected byte[] cv_soumis;

    /**
     * Get the value of cv_soumis
     *
     * @return the value of cv_soumis
     */
    public byte[] getCv_soumis() {
        return cv_soumis;
    }

    /**
     * Set the value of cv_soumis
     *
     * @param cv_soumis new value of cv_soumis
     */
    public void setCv_soumis(byte[] cv_soumis) {
        this.cv_soumis = cv_soumis;
    }

    /**
     * Set the value of dataInscription
     *
     * @param dataInscription new value of dataInscription
     */
    public void setDataInscription(Date dataInscription) {
        this.dataInscription = dataInscription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participant)) {
            return false;
        }
        Participant other = (Participant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcertif.bo.Participant[id=" + id + "]";
    }
}
