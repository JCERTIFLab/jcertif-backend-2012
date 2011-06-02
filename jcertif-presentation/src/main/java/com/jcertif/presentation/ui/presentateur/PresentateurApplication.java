/**
 * 
 */
package com.jcertif.presentation.ui.presentateur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.ui.JCertifApplication;
import com.vaadin.ui.Window;

/**
 * Proposition de sujet Application.
 * 
 * @author max
 * 
 */
public class PresentateurApplication extends JCertifApplication {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PresentateurApplication.class);

	@Override
	public void init() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Initialize Presentateur Application");
		}
		setTheme("jcertifruno");
		final Window mainWindow = new Window();
		mainWindow.getContent().addComponent(new PresentateurDetailComponent());
		setMainWindow(mainWindow);
	}

}
