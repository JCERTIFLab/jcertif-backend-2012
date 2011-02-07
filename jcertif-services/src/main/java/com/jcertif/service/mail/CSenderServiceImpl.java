/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.service.mail;

import com.jcertif.bo.participant.ProfilUtilisateur;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

/**
 *
 * @author Douneg
 */
@Service
public class CSenderServiceImpl extends CSenderService {

    @Override
    public Boolean sendConfirmation(final ProfilUtilisateur profilUtilisateur, final String from) {
        Properties props = new Properties();
        props.put("mail.smtp.host", getHost());
        props.put("mail.smtp.socketFactory.port", getSocketFactoryPort());
        props.put("mail.smtp.socketFactory.class", getSocketFactoryClass());
        props.put("mail.smtp.auth", getAuth());
        props.put("mail.smtp.port", getSmtpPort());

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(getUserName(), getPassword());
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(getUserName()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(profilUtilisateur.getEmail()));
            message.setSubject("Confirmation JCertif");
            message.setText("Cher Participant " + profilUtilisateur.getNomProfil() + ",\n\nMerci de vous être enregistré a JCertif 2011\n\nAdministrateur JCertif");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return Boolean.TRUE;
    }
}
