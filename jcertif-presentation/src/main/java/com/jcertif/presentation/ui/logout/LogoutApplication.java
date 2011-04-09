package com.jcertif.presentation.ui.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcertif.presentation.ui.util.UIConst;
import com.vaadin.Application;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.Window;

/**
 * @author rossi
 * 
 */
public class LogoutApplication extends Application implements HttpServletRequestListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		setMainWindow(new Window());
	}

	@Override
	public void onRequestStart(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public void onRequestEnd(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession().getAttribute(UIConst.PARAM_CONNECTED) != null
				&& request.getSession().getAttribute(UIConst.PARAM_CONNECTED).equals(Boolean.TRUE)) {

			request.getSession().setAttribute(UIConst.PARAM_CONNECTED, null);
			request.getSession().setAttribute(UIConst.PARAM_LASTNAME, null);
			request.getSession().setAttribute(UIConst.PARAM_FIRSTNAME, null);
			request.getSession().setAttribute(UIConst.PARAM_EMAIL, null);

			String urlRedirect = (String) request.getSession().getAttribute("url");
			ExternalResource res = new ExternalResource(urlRedirect);
			getMainWindow().open(res);

		}
	}

}
