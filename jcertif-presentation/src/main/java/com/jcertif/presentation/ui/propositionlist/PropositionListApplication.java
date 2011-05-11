package com.jcertif.presentation.ui.propositionlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.ui.presentateur.PresentateurApplication;
import com.vaadin.Application;
import com.vaadin.ui.Window;

/**
 * @author rossi.oddet
 * 
 */
public class PropositionListApplication extends Application {

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
		mainWindow.getContent().addComponent(
				new PropositionListDetailComponent());
		setMainWindow(mainWindow);
	}
}
