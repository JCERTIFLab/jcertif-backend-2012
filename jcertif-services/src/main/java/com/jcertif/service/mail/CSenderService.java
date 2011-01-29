/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.service.mail;

import com.jcertif.bo.participant.ProfilUtilisateur;

/**
 *
 * @author Douneg
 */
public interface CSenderService {

    void sendConfirmation(ProfilUtilisateur profilUtilisateur, String from);
}
