package com.jcertif.presentation.ui.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.ui.util.UIConst;
import com.vaadin.Application;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Window;

/**
 * Login Application.
 * 
 * @author rossi
 * 
 */
public class LoginApplication extends Application implements ClickListener,
		HttpServletRequestListener {

	private static final long serialVersionUID = 1L;

	/**
	 * A logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginApplication.class);

	/**
	 * Un participant connecté.
	 */
	private Participant connectedPart;

	/**
	 * Redirect URL.
	 */
	private String urlRedirect = "accueil.jsp";

	/**
	 * Login Form.
	 */
	private LoginForm loginForm;

	/**
	 * @see com.vaadin.Application#init()
	 */
	@Override
	public void init() {
		LOGGER.info("Initialize Login Application");
		final Window mainWindow = new Window();
		mainWindow.getContent().addComponent(getLoginForm());
		getLoginForm().getLoginButton().addListener(this);
		setMainWindow(mainWindow);
	}

	/**
	 * @return the loginForm
	 */
	public LoginForm getLoginForm() {
		if (loginForm == null) {
			loginForm = new LoginForm();
		}
		return loginForm;
	}

	/**
	 * @param event
	 */
	@Override
	public void buttonClick(ClickEvent event) {
		connectedPart = getLoginForm().commitAndGetParticipant();
		this.getMainWindow();
		ExternalResource res = new ExternalResource(urlRedirect);
		this.getMainWindow().open(res);
	}

	@Override
	public void onRequestStart(HttpServletRequest request, HttpServletResponse response) {
		urlRedirect = (String) request.getSession().getAttribute("url");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Login request with urlRedirect={}", urlRedirect);
		}

		if (connectedPart != null) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("------- User is already connected. Email={}",
						connectedPart.getEmail());
			}
			ExternalResource res = new ExternalResource(urlRedirect);
			this.getMainWindow().open(res);
		}
	}

	@Override
	public void onRequestEnd(HttpServletRequest request, HttpServletResponse response) {
		if (connectedPart != null
				&& request.getSession().getAttribute(UIConst.PARAM_CONNECTED) == null) {
			request.getSession().setAttribute(UIConst.PARAM_CONNECTED, true);
			request.getSession().setAttribute(UIConst.PARAM_LASTNAME, connectedPart.getNom());
			request.getSession().setAttribute(UIConst.PARAM_FIRSTNAME, connectedPart.getPrenom());
			request.getSession().setAttribute(UIConst.PARAM_EMAIL, connectedPart.getEmail());
		}
	}

}
