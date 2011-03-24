/**
 * 
 */
package com.jcertif.presentation.ui.propositionPresentation;

import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.conference.Conference;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;
import com.jcertif.presentation.wsClient.ConferenceClient;
import com.jcertif.presentation.wsClient.ParticipantClient;
import com.jcertif.presentation.wsClient.PropositionPresentationClient;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

/**
 * Formulation de proposition de sujet de présentation.
 * 
 * @author max
 * 
 */

public class PropositionPresentationForm extends Form {

	private static final Object[] VISIBLE_PROPERTIES = new Object[] { "titre", "description",
			"topic", "sommaire", "besoinsSpecifiques", "keyWord"};
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(PropositionPresentationForm.class);

	public PropositionPresentationForm() {
		super();
		init();
	}

	private void init() {
		// this.setLayout(new VerticalLayout());
		this.getLayout().setMargin(true);
		setFormFieldFactory(new PropositionPresentationFieldFactory());

		PropositionPresentation bean = new PropositionPresentation();

		// Initialisation de la conférence
		List<Conference> conferences = ConferenceClient.getInstance().findAllXML();

		if (conferences == null || conferences.isEmpty()) {
			LOGGER.error("Aucune conférence n'est présente côté facade");
		} else {
			// TODO définir avec Max une clé fonctionnelle pour la conférence à
			// choisir
			bean.setConference(conferences.iterator().next());
		}

		// Init à la date du jour
		//bean.setDateInscription(Calendar.getInstance());

		// Mapping BO Bean Form
		BeanItem<PropositionPresentation> item = new BeanItem<PropositionPresentation>(bean);
		this.setItemDataSource(item);
		this.setVisibleItemProperties(VISIBLE_PROPERTIES);

		// Footer avec le bouton enregistrer
		Button saveProposition = new Button("Enregistrer", this, "commit");
		HorizontalLayout layoutFooter = new HorizontalLayout();
		layoutFooter.addComponent(saveProposition);
		this.setFooter(layoutFooter);

		this.setCaption("Proposer une présentation à JCERTIF 2011");
		this.setDescription("Veuillez remplir ce formulaire afin de proposer une présentation ");

	}

	/**
	 * @see com.vaadin.ui.Form#commit()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void commit() throws SourceException {
		// TODO Auto-generated method stub
		super.commit();
		try {
			PropositionPresentationClient.getInstance().create_XML(
					((BeanItem<PropositionPresentation>) this.getItemDataSource()).getBean());
			Window main = getApplication().getMainWindow();
			// Create a notification with default settings for a warning.
			ExternalResource res = new ExternalResource("confirmationInscription.jsp");
			main.open(res);
		} catch (UniformInterfaceException e) {
			getApplication().getMainWindow().showNotification("Email incorrect");
			// TODO Gestion de l'exception
			e.getResponse();
		}

	}

}
