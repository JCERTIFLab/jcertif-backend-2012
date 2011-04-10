/**
 * 
 */
package com.jcertif.presentation.ui.presentateur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.Application;
import com.vaadin.ui.Window;

/**
 * Proposition de sujet Application.
 * 
 * @author max
 * 
 */
public class PresentateurApplication extends Application {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(PresentateurApplication.class);

	@Override
	public void init() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Initialize Presentateur Application");
		}
		final Window mainWindow = new Window();
		mainWindow.getContent().addComponent(new PresentateurDetailComponent());
		setMainWindow(mainWindow);
	}

}
