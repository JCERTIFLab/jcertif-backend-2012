/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.bo;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Douneg
 */
@MappedSuperclass
public class Person implements Serializable {

    public Person() {
    }
    @Id
    @GeneratedValue
    protected Long id;
    protected String nom;
    protected String prenom;
    protected String sexe_MF;
    protected String telephone;
    protected String salutation;
    protected String specialite;
    protected String adresse;
    protected String details;
    protected String email;

    public String getDetails() {
        return details;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe_MF() {
        return sexe_MF;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe_MF(String sexe_MF) {
        this.sexe_MF = sexe_MF;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Get the value of salutation
     *
     * @return the value of salutation
     */
    public String getSalutation() {
        return salutation;
    }

    /**
     * Get the value of specialite
     *
     * @return the value of specialite
     */
    public String getSpecialite() {
        return specialite;
    }

    /**
     * Set the value of salutation
     *
     * @param salutation new value of salutation
     */
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    /**
     * Set the value of specialite
     *
     * @param specialite new value of specialite
     */
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    /**
     * Get the value of adresse
     *
     * @return the value of adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Set the value of adresse
     *
     * @param adresse new value of adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
