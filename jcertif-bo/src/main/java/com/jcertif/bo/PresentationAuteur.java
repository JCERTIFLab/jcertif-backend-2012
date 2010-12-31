/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcertif.bo;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author Douneg
 */
@Entity
public class PresentationAuteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PresentationAuteurPK presentationAuteurPK;

   

    

}
