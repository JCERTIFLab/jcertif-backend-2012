package com.jcertif.presentation.ui.apropos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.ui.JCertifApplication;
import com.vaadin.ui.Window;

/**
 * @author rossi
 * 
 */
public class AproposApplication extends JCertifApplication {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AproposApplication.class);

	@Override
	public void init() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Initialize AproposApplication");
		}
		setTheme("jcertifruno");
		final Window mainWindow = new Window();
		mainWindow.getContent().addComponent(new AproposDetailComponent());
		setMainWindow(mainWindow);
	}

}