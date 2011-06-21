/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.facade.model;

import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rossi.oddet
 */
@XmlRootElement
public class IdList {

    private String value = "";

    public IdList(){
    }
    public IdList(Set<Long> longList) {
        for (Long longId : longList) {
            if ("".equals(value)) {
                value += longId;
            } else {
                value += "," + longId;
            }
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}
