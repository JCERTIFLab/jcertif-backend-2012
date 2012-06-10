/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.facade.model.participant;

import com.jcertif.bo.participant.Participant;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rossi.oddet
 */
@XmlRootElement
public class Speaker {

    private Long id;
    /**
     * Prenom d'une personne.
     */
    private String prenom;
    /**
     * Nom d'une personne.
     */
    private String nom;
    private String compagnie;
    private String photo;
    private String bio;
    
    public Speaker(){
        super();
    }

    public Speaker(Participant part) {
        this.id = part.getId();
        this.prenom = part.getPrenom();
        this.nom=part.getNom();
        this.compagnie=part.getCompagnie();
        this.bio=part.getDetails();
        this.photo=part.getProfilUtilisateur().getPhoto();
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
}
