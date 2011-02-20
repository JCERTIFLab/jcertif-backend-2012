/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.service.mail;

import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.participant.ProfilUtilisateur;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.URLDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author Douneg
 */
@Service
public class CSenderServiceImpl extends CSenderService {

    @Override
    @Async
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
            message.setSubject("Confirmation Enregistrement Participation JCertif 2011");
            // Add html content

// Specify the cid of the image to include in the email
            StringTemplateGroup group = new StringTemplateGroup("mailTemplate");
            StringTemplate st = group.getInstanceOf("com/jcertif/service/mail/confirmParticipant");
            st.setAttribute(from, st);
            String html = st.toString();
            Multipart mp = new MimeMultipart();
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(html, "text/html");
            mp.addBodyPart(htmlPart);
            MimeBodyPart imagePart = new MimeBodyPart();
            DataSource fds = new FileDataSource(new File(new URI(getPhotoURI())));
            imagePart.setDataHandler(new DataHandler(fds));

// assign a cid to the image

            imagePart.setHeader("Content-ID", "image");
            mp.addBodyPart(imagePart);
            message.setContent(mp);
            Transport.send(message);

        } catch (URISyntaxException ex) {
            Logger.getLogger(CSenderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return Boolean.TRUE;
    }

    @Override
    @Async
    public Boolean sendAddParticipantConfirmation(final Participant participant) {
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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(participant.getEmail()));
            message.setSubject("Confirmation Enregistrement Participation JCertif 2011");
            // Add html content

// Specify the cid of the image to include in the email
            StringTemplateGroup group = new StringTemplateGroup("mailTemplate");
            StringTemplate st = group.getInstanceOf("com/jcertif/service/mail/confirmParticipant");
            st.setAttribute("participant", participant);

            String html = st.toString();
            System.out.println("Message "+html);
            Multipart mp = new MimeMultipart();
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(html, "text/html");
            mp.addBodyPart(htmlPart);
            MimeBodyPart imagePart = new MimeBodyPart();
            URL url = getClass().getResource(getPhotoURI());
            DataSource fds = new URLDataSource(url);
            imagePart.setDataHandler(new DataHandler(fds));

// assign a cid to the image

            imagePart.setHeader("Content-ID", "image");
            mp.addBodyPart(imagePart);
            message.setContent(mp);
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return Boolean.TRUE;
    }
}