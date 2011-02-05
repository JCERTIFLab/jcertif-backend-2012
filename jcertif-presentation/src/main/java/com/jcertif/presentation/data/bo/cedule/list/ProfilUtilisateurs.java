package com.jcertif.presentation.data.bo.cedule.list;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jcertif.presentation.data.bo.participant.ProfilUtilisateur;

/**
 * 
 * @author Badr
 *
 */
@XmlRootElement
public class ProfilUtilisateurs {

    protected List<ProfilUtilisateur> profils = new ArrayList<ProfilUtilisateur>();

    public ProfilUtilisateurs() {
    }

    public ProfilUtilisateurs(List<ProfilUtilisateur> profils) {
        this.profils = profils;
    }

    @XmlElement(name = "profilUtilisateur")
    public List<ProfilUtilisateur> getProfilUtilisateurs() {
        return profils;
    }
}
