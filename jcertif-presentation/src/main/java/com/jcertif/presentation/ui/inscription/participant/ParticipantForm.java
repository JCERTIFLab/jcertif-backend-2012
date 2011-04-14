/**
 * 
 */
package com.jcertif.presentation.ui.inscription.participant;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.conference.Conference;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.internationalisation.Messages;
import com.jcertif.presentation.wsClient.ConferenceClient;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Form;

/**
 * Formulation d'inscription d'un participant.
 * 
 * @author rossi
 * 
 */
public class ParticipantForm extends Form {

	private static final Object[] VISIBLE_PROPERTIES = new Object[] { "salutation", "prenom",
			"nom", "roleparticipant", "typeParticipant", "compagnie", "website" };
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(ParticipantForm.class);

	public ParticipantForm() {
		super();
		init();
	}

	private void init() {
		// this.setLayout(new VerticalLayout());
		this.getLayout().setMargin(true);
		setFormFieldFactory(new ParticipantFieldFactory());

		reinitParticipantBean();
		this.setCaption(Messages.getString("Presentation.inscription_caption"));
	}

	/**
	 * 
	 */
	public void reinitParticipantBean() {
		Participant bean = new Participant();

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
		bean.setDateInscription(Calendar.getInstance());

		// Mapping BO Bean Form
		BeanItem<Participant> item = new BeanItem<Participant>(bean);
		this.setItemDataSource(item);
		this.setVisibleItemProperties(VISIBLE_PROPERTIES);
	}

}
