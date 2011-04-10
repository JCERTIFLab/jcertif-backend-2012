/**
 * 
 */
package com.jcertif.presentation.ui.partenaire;

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
public class PartenaireApplication extends Application {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(PartenaireApplication.class);

	@Override
	public void init() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Initialize Presentateur Application");
		}
		setTheme("jcertifruno");
		final Window mainWindow = new Window();
		mainWindow.getContent().addComponent(new PartenaireDetailComponent());
		setMainWindow(mainWindow);
	}

}
