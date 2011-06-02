/**
 * 
 */
package com.jcertif.presentation.ui.faq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.ui.JCertifApplication;
import com.vaadin.ui.Window;

/**
 * Foire aux question Application.
 * 
 * @author max
 * 
 */
public class FaqApplication extends JCertifApplication {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FaqApplication.class);

	@Override
	public void init() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Initialize FAQ Application");
		}
		setTheme("jcertifruno");
		final Window mainWindow = new Window();
		mainWindow.getContent().addComponent(new FaqDetailComponent());
		setMainWindow(mainWindow);
	}

}
