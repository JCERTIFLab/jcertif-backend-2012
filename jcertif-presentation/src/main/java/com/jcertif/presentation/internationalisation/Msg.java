package com.jcertif.presentation.internationalisation;

import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

public class Msg {
	private static final String BUNDLE_NAME = "i18n.messages"; //$NON-NLS-1$

	private Msg() {
	}

	public static String getString(String key, Locale locale) {
		try {
			// ResourceBundle caches the bundles, so this is not as inefficient
			// as it seems.
			return ResourceBundle.getBundle(BUNDLE_NAME, locale).getString(key);
		} catch (MissingResourceException e) {
			return '«' + key + '»';
		}
	}

	public static String get(String key) {
		try {
			// ResourceBundle caches the bundles, so this is not as inefficient
			// as it seems.
			return ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault()).getString(key);
		} catch (MissingResourceException e) {
			return '«' + key + '»';
		}
	}

	public static void initI18n(HttpSession session) {

		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault());
		Enumeration<String> enumKeys = bundle.getKeys();

		while (enumKeys.hasMoreElements()) {
			String key = enumKeys.nextElement();
			session.setAttribute(key, bundle.getString(key));
		}
	}
}
