/**
 * 
 */
package com.jcertif.presentation.ui.inscription;

import com.jcertif.presentation.action.ParticipantAction;
import com.jcertif.presentation.panel.CreationParticipantPanel;
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

	@Override
	public void init() {

		final Window mainWindow = new Window();
		mainWindow.getContent().addComponent(new CreationParticipantPanel(new ParticipantAction()));
		setMainWindow(mainWindow);

	}


}
