package com.jcertif.presentation.data.bo.participant;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.presentation.data.bo.AbstractBO;

/**
 *
 * @author Douneg
 */
@XmlRootElement
public class ProfilUtilisateur extends AbstractBO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nomProfil;
    private String email;
    private String password;
    protected String confirmPassword;
    private String photo;
    private String langueCorrespondance;
    protected String codeConfirmation;

    public ProfilUtilisateur() {
        super();
    }

    /**
     * Un constructeur.
     *
     * @param id
     *            un id
     * @param nomProfil
     *            nom Profil
     * * @param email
     *           email
     * @param password
     *            mot de passe
     * @param photo
     *            uri photo
     * @param langueCorrespondance
     *            langue de Correspondance
     * @param codeConfirmation
     *            code de Confirmation
     */
    public ProfilUtilisateur(Long id, String nomProfil, String email, String password, String photo, String langueCorrespondance, String codeConfirmation) {
        super();
        this.id = id;
        this.nomProfil = nomProfil;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.langueCorrespondance = langueCorrespondance;
        this.codeConfirmation = codeConfirmation;
    }

    /**
     * Get the value of codeConfirmation
     *
     * @return the value of codeConfirmation
     */
    public String getCodeConfirmation() {
        return codeConfirmation;
    }

    /**
     * Set the value of codeConfirmation
     *
     * @param codeConfirmation new value of codeConfirmation
     */
    public void setCodeConfirmation(String codeConfirmation) {
        this.codeConfirmation = codeConfirmation;
    }

    /**
     * Get the value of langueCorrespondance
     *
     * @return the value of langueCorrespondance
     */
    public String getLangueCorrespondance() {
        return langueCorrespondance;
    }

    /**
     * Set the value of langueCorrespondance
     *
     * @param langueCorrespondance new value of langueCorrespondance
     */
    public void setLangueCorrespondance(String langueCorrespondance) {
        this.langueCorrespondance = langueCorrespondance;
    }

    /**
     * Get the value of photo
     *
     * @return the value of photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Set the value of photo
     *
     * @param photo new value of photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * Get the value of confirmPassword
     *
     * @return the value of confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * Set the value of confirmPassword
     *
     * @param confirmPassword new value of confirmPassword
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the value of nomProfil
     *
     * @return the value of nomProfil
     */
    public String getNomProfil() {
        return nomProfil;
    }

    /**
     * Set the value of nomProfil
     *
     * @param nomProfil new value of nomProfil
     */
    public void setNomProfil(String nomProfil) {
        this.nomProfil = nomProfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getId()).
                append(this.getEmail()).
                append(this.getLangueCorrespondance()).
                append(this.getCodeConfirmation()).
                append(this.getNomProfil()).
                append(this.getPhoto()).toHashCode();
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ProfilUtilisateur)) {
            return false;
        }

        final ProfilUtilisateur other = (ProfilUtilisateur) obj;

        return new EqualsBuilder().append(this.getId(), other.getId()).
                append(this.getEmail(), other.getEmail()).
                append(this.getLangueCorrespondance(), other.getLangueCorrespondance()).
                append(this.getCodeConfirmation(), other.getCodeConfirmation()).
                append(this.getNomProfil(), other.getNomProfil()).
                append(this.getPhoto(), other.getPhoto()).isEquals();
    }
}
