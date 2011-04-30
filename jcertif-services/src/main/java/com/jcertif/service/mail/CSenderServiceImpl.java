/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.service.mail;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.participant.ProfilUtilisateur;
import com.jcertif.bo.presentation.PropositionPresentation;
import com.jcertif.service.api.participant.ParticipantService;

/**
 * 
 * @author Douneg
 */
@Service
public class CSenderServiceImpl extends CSenderService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CSenderServiceImpl.class);

	@Autowired
	private ParticipantService participantService;

	@Override
	@Async
	public Boolean sendConfirmation(final ProfilUtilisateur profilUtilisateur,
			final String from) {
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
						return new PasswordAuthentication(getUserName(),
								getPassword());
					}
				});

		String recipients = getDiffusionList() + ","
				+ profilUtilisateur.getEmail();
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(getUserName()));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(recipients));
			message.setSubject("Confirmation Enregistrement Participation JCertif 2011");
			// Add html content

			// Specify the cid of the image to include in the email
			StringTemplateGroup group = new StringTemplateGroup("mailTemplate");
			StringTemplate st = group
					.getInstanceOf("com/jcertif/service/mail/confirmParticipant");
			st.setAttribute(from, st);
			String html = st.toString();
			Multipart mp = new MimeMultipart();
			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(html, "text/html");
			mp.addBodyPart(htmlPart);
			MimeBodyPart imagePart = new MimeBodyPart();
			DataSource fds = new FileDataSource(
					new File(new URI(getPhotoURI())));
			imagePart.setDataHandler(new DataHandler(fds));

			// assign a cid to the image

			imagePart.setHeader("Content-ID", "image");
			mp.addBodyPart(imagePart);
			message.setContent(mp);
			Transport.send(message);

		} catch (URISyntaxException e) {
			LOGGER.error("", e);
			throw new RuntimeException(e);
		} catch (MessagingException e) {
			LOGGER.error("", e);
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
						return new PasswordAuthentication(getUserName(),
								getPassword());
					}
				});

		String recipients = getDiffusionList() + "," + participant.getEmail();

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(getUserName()));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(recipients));
			message.setSubject("Confirmation Enregistrement Participation JCertif 2011");
			// Add html content

			Multipart mp = new MimeMultipart();

			// Specify the cid of the image to include in the email
			StringTemplateGroup group = new StringTemplateGroup("mailTemplate");
			StringTemplate st = group
					.getInstanceOf("com/jcertif/service/mail/confirmParticipant");
			st.setAttribute("participant", participant);

			// Ajout des photos des partenaires
			String partenaires = ajoutImagesPartenaire(mp);
			st.setAttribute("partenaires", partenaires);

			String html = st.toString();
			System.out.println("Message " + html);

			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(html, "text/html");
			mp.addBodyPart(htmlPart);
			MimeBodyPart imagePart = new MimeBodyPart();
			URL url = getClass().getResource(getPhotoURI());
			DataSource fds = new URLDataSource(url);
			imagePart.setDataHandler(new DataHandler(fds));

			// assign a cid to the image

			imagePart.setHeader("Content-ID", "<image>");
			mp.addBodyPart(imagePart);

			message.setContent(mp);
			Transport.send(message);

		} catch (MessagingException e) {
			LOGGER.error("", e);
			throw new RuntimeException(e);
		} catch (MalformedURLException e) {
			LOGGER.error("", e);
			throw new RuntimeException(e);
		}
		return Boolean.TRUE;
	}

	private String ajoutImagesPartenaire(Multipart mp)
			throws MalformedURLException, MessagingException {
		String partenaires = "";

		Set<Participant> participants = new HashSet(
				participantService.findAll());

		int i = 0;
		for (Participant partenaire : participants) {
			if (partenaire.getRoleparticipant() != null
					&& "Partenaire".equalsIgnoreCase(partenaire
							.getRoleparticipant().getCode())) {
				MimeBodyPart imagePartenaire = new MimeBodyPart();
				URL urlpart = new URL(getPicsUrl() + "/Partenaire/"
						+ partenaire.getProfilUtilisateur().getPhoto());
				DataSource fdsPart = new URLDataSource(urlpart);
				imagePartenaire.setDataHandler(new DataHandler(fdsPart));

				// assign a cid to the image

				imagePartenaire.setHeader("Content-ID", "<image_partenaire" + i
						+ ">");

				partenaires += "<td><a href=\"" + partenaire.getWebsite()
						+ "\"><img style= \"width: 150px;\" alt=\""
						+ "JCertif Logo\" src=\"cid:image_partenaire" + i
						+ "\"></a></td>";

				mp.addBodyPart(imagePartenaire);
				i++;

			}
		}
		return partenaires;
	}

	@Override
	@Async
	public Boolean sendAddPropositionConfirmation(PropositionPresentation propo) {
		Session session = initSession();
		String recipients = getDiffusionList();

		if (propo.getParticipants() != null
				&& !propo.getParticipants().isEmpty()) {
			recipients += ","
					+ propo.getParticipants().iterator().next().getEmail();
		}

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(getUserName()));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(recipients));
			message.setSubject("Confirmation Proposition Présentation JCertif 2011");
			// Add html content
			Multipart mp = new MimeMultipart();
			// Specify the cid of the image to include in the email
			StringTemplateGroup group = new StringTemplateGroup("mailTemplate");
			StringTemplate st = group
					.getInstanceOf("com/jcertif/service/mail/confirmProposition");
			st.setAttribute("proposition", propo);

			// Ajout des photos des partenaires
			String partenaires = ajoutImagesPartenaire(mp);
			st.setAttribute("partenaires", partenaires);

			String html = st.toString();

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Message " + html);
			}

			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(html, "text/html");
			mp.addBodyPart(htmlPart);
			MimeBodyPart imagePart = new MimeBodyPart();
			URL url = getClass().getResource(getPhotoURI());
			DataSource fds = new URLDataSource(url);
			imagePart.setDataHandler(new DataHandler(fds));

			// assign a cid to the image

			imagePart.setHeader("Content-ID", "<image>");
			mp.addBodyPart(imagePart);
			message.setContent(mp);
			Transport.send(message);

		} catch (MessagingException e) {
			LOGGER.error("", e);
			throw new RuntimeException(e);
		} catch (MalformedURLException e) {
			LOGGER.error("", e);
			throw new RuntimeException(e);
		}
		return Boolean.TRUE;
	}

	/**
	 * @return
	 */
	private String getDiffusionList() {
		ResourceBundle bundle = ResourceBundle.getBundle("service");
		return bundle.getString("diffusion");
	}

	private String getPicsUrl() {
		ResourceBundle bundle = ResourceBundle.getBundle("service");
		return bundle.getString("pics.url");

	}

	/**
	 * @return
	 */
	private Session initSession() {
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
						return new PasswordAuthentication(getUserName(),
								getPassword());
					}
				});
		return session;
	}
}
