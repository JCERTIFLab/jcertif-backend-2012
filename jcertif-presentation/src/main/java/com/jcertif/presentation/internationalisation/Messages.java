package com.jcertif.presentation.internationalisation;


import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	private static final String BUNDLE_NAME = "i18n.messages"; //$NON-NLS-1$

//	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Messages() {
	}
	
	public static String getString(String key, Locale locale) {
		try {
			// ResourceBundle caches the bundles, so this is not as inefficient as it seems.
			return ResourceBundle.getBundle(BUNDLE_NAME, locale).getString(key);
		} catch (MissingResourceException e) {
			return '«' + key + '»';
		}
	}
}
