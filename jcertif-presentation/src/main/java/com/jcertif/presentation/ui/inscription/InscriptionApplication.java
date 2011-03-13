/**
 * 
 */
package com.jcertif.presentation.ui.inscription;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.Application;
import com.vaadin.ui.Window;

/**
 * Inscription Application.
 * 
 * @author rossi
 * 
 */
public class InscriptionApplication extends Application {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(InscriptionApplication.class);

	@Override
	public void init() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Initialize Inscription Application");
		}
		final Window mainWindow = new Window();
		mainWindow.getContent().addComponent(new InscriptionForm());
		setMainWindow(mainWindow);
	}

}
