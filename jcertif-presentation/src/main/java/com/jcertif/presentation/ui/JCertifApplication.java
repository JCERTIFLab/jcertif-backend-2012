/**
 * 
 */
package com.jcertif.presentation.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcertif.presentation.internationalisation.Msg;
import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;

/**
 * @author rossi
 * 
 */
public abstract class JCertifApplication extends Application implements
		HttpServletRequestListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void onRequestStart(HttpServletRequest request,
			HttpServletResponse response) {
		Msg.updateLocale(request.getHeader("Accept-Language"));
	}

	@Override
	public void onRequestEnd(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
