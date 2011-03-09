/**
 * 
 */
package com.jcertif.presentation.ui.inscription;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.action.ParticipantAction;
import com.jcertif.presentation.data.bo.conference.Conference;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.panel.CreationParticipantPanel;
import com.jcertif.presentation.wsClient.ConferenceClient;
import com.vaadin.Application;
import com.vaadin.ui.Window;

/**
 * @author rossi
 * 
 */
public class CreationParticipantApplication extends Application {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CreationParticipantApplication.class);

	@Override
	public void init() {

		final Window mainWindow = new Window();
		Participant participant = new Participant();
		participant.setDateInscription(Calendar.getInstance());
		List<Conference> conferences = ConferenceClient.getInstance().findAll_XML();
		
		if(conferences == null || conferences.isEmpty()){
			LOGGER.warn("Aucune conférence n'est présente côté facade");
		} else {
			// TODO définir avec Max une clé fonctionnelle pour la conférence à choisir
			participant.setConference(conferences.iterator().next());
		}
		
		mainWindow.getContent().addComponent(new CreationParticipantPanel(new ParticipantAction()));
		setMainWindow(mainWindow);

	}

}
