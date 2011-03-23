/**
 * 
 */
package com.jcertif.presentation.ui.propositionPresentation;

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
public class PropositionPresentationApplication extends Application {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(PropositionPresentationApplication.class);

	@Override
	public void init() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Initialize Proposition Sujet Application");
		}
		final Window mainWindow = new Window();
		mainWindow.getContent().addComponent(new PropositionPresentationForm());
		setMainWindow(mainWindow);
	}

}
