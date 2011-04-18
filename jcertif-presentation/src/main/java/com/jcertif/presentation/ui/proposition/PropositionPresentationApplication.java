/**
 * 
 */
package com.jcertif.presentation.ui.proposition;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.ui.util.UIConst;
import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.Window;

/**
 * Proposition de sujet Application.
 * 
 * @author max
 * 
 */
public class PropositionPresentationApplication extends Application implements
		HttpServletRequestListener {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PropositionPresentationApplication.class);

	private PropositionPresentationForm propForm;

	@Override
	public void init() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Initialize Proposition Sujet Application");
		}
		final Window mainWindow = new Window();
		mainWindow.getContent().addComponent(getPropForm());
		setMainWindow(mainWindow);
	}

	/**
	 * @return the propForm
	 */
	public PropositionPresentationForm getPropForm() {
		if (propForm == null) {
			propForm = new PropositionPresentationForm();
		}
		return propForm;
	}

	@Override
	public void onRequestStart(HttpServletRequest request, HttpServletResponse response) {
		getPropForm().setContextPath(request.getContextPath());
		getPropForm().setEmailParticipant(
				(String) request.getSession().getAttribute(UIConst.PARAM_EMAIL));
	}

	@Override
	public void onRequestEnd(HttpServletRequest request, HttpServletResponse response) {

	}

}
