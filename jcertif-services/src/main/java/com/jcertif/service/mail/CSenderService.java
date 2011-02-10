/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.service.mail;

import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.participant.ProfilUtilisateur;

/**
 *
 * @author Douneg
 */
public abstract class CSenderService {

    private String userName;
    private String password;
    private String host;
    private String socketFactoryPort;
    private String socketFactoryClass;
    private String auth;
    private String smtpPort;
    private String photoURI;

    public String getPhotoURI() {
        return photoURI;
    }

    public void setPhotoURI(String photoURI) {
        this.photoURI = photoURI;
    }

    public String getAuth() {
        return auth;
    }

    public String getHost() {
        return host;
    }

    public String getPassword() {
        return password;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public String getSocketFactoryClass() {
        return socketFactoryClass;
    }

    public String getSocketFactoryPort() {
        return socketFactoryPort;
    }

    public String getUserName() {
        return userName;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public void setSocketFactoryClass(String socketFactoryClass) {
        this.socketFactoryClass = socketFactoryClass;
    }

    public void setSocketFactoryPort(String socketFactoryPort) {
        this.socketFactoryPort = socketFactoryPort;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public abstract Boolean sendConfirmation(ProfilUtilisateur profilUtilisateur, String from);
    public abstract Boolean sendAddParticipantConfirmation(final Participant participant);
}
