/**
 * 
 */
package com.jcertif.presentation.ui.organisateur;

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
public class OrganisateurApplication extends Application {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrganisateurApplication.class);

	@Override
	public void init() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Initialize Partenaires Application");
		}
		setTheme("jcertifruno");
		final Window mainWindow = new Window();
		mainWindow.getContent().addComponent(new OrganisateurDetailComponent());
		setMainWindow(mainWindow);
	}

}
