/**
 * 
 */
package com.jcertif.presentation.ui.inscription;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.data.bo.participant.ProfilUtilisateur;
import com.jcertif.presentation.internationalisation.Messages;
import com.jcertif.presentation.ui.inscription.participant.ParticipantForm;
import com.jcertif.presentation.ui.inscription.profilutilisateur.ProfilUtilisateurBean;
import com.jcertif.presentation.ui.inscription.profilutilisateur.ProfilUtilisateurForm;
import com.jcertif.presentation.ui.util.UIConst;
import com.jcertif.presentation.wsClient.ParticipantClient;
import com.vaadin.Application;
import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.UserError;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Form;
import com.vaadin.ui.Window;

/**
 * Inscription Application.
 * 
 * @author rossi
 * 
 */
public class InscriptionApplication extends Application implements ClickListener,
		HttpServletRequestListener {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(InscriptionApplication.class);

	private ProfilUtilisateurForm profilForm;

	private ParticipantForm participantForm;

	private Form addressForm;

	private String contextPath;

	@Override
	public void init() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Initialize Inscription Application");
		}
		profilForm = new ProfilUtilisateurForm();
		participantForm = new ParticipantForm();
		final Window mainWindow = new Window();
		mainWindow.getContent().addComponent(profilForm);
		mainWindow.getContent().addComponent(participantForm);
		Button commitButton = new Button(Messages.getString("Presentation.enregistrer",
				Locale.getDefault()));
		commitButton.addListener(this);
		mainWindow.getContent().addComponent(commitButton);
		setMainWindow(mainWindow);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (commitProfilForm()) {
			if (commitParticipant()) {
				Participant participant = ((BeanItem<Participant>) participantForm
						.getItemDataSource()).getBean();

				ProfilUtilisateur profilUtilisateur = (ProfilUtilisateur) ((BeanItem<ProfilUtilisateurBean>) profilForm
						.getItemDataSource()).getBean();

				participant.setEmail(profilUtilisateur.getEmail());
				participant.setProfilUtilisateur(profilUtilisateur);
				ParticipantClient.getInstance().create_XML(participant);
				participantForm.initParticipantBean();
				profilForm.initProfilBean();
				ExternalResource res = new ExternalResource(contextPath + UIConst.CONFIRMATION_VIEW);
				this.getMainWindow().open(res);
			}
		}

	}

	private boolean commitParticipant() {
		boolean result = true;
		participantForm.commit();
		ParticipantClient client = ParticipantClient.getInstance();
		if (client.isEmailExist(((BeanItem<Participant>) participantForm.getItemDataSource())
				.getBean().getEmail())) {
			participantForm
					.setComponentError(new UserError("Cette adresse email est déjà utilisé."));
			result = false;
		}
		return result;
	}

	private boolean commitProfilForm() {
		boolean result = true;
		profilForm.commit();
		if (!profilForm.getField("confirmEmail").getValue()
				.equals(profilForm.getField("email").getValue())) {
			profilForm.setComponentError(new UserError(
					"Les adresses email saisies ne sont identiques."));
			result = false;
		} else if (!profilForm.getField("confirmPassword").getValue()
				.equals(profilForm.getField("password").getValue())) {
			profilForm.setComponentError(new UserError(
					"Les adresses email saisies ne sont identiques."));
			result = false;
		}
		return result;
	}

	@Override
	public void onRequestStart(HttpServletRequest request, HttpServletResponse response) {
		contextPath = request.getContextPath();
	}

	@Override
	public void onRequestEnd(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
