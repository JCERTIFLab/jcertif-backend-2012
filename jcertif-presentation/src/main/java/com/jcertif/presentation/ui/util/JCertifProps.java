package com.jcertif.presentation.ui.util;

import java.util.ResourceBundle;

/**
 * Utility class for presentation properties.
 * 
 * @author rossi.oddet
 * 
 */
public final class JCertifProps {

	private static final String FACADE_URL_PROP = "facade.url";
	private static final String PHOTO_TMP_DIR = "tmp.photo.dir";
	private static final String WEBAPP_PROPERTIES_FILE = "jcertif-presentation";

	private static JCertifProps instance;

	private String facadeUrl;

	private String photoTmpDirectory;

	public static JCertifProps getInstance() {
		if (instance == null) {
			instance = new JCertifProps();
		}
		return instance;
	}

	private String getProperty(String name) {
		ResourceBundle bundle = ResourceBundle.getBundle(WEBAPP_PROPERTIES_FILE);
		return bundle.getString(name);
	}

	/**
	 * @return the facadeUrl
	 */
	public String getFacadeUrl() {
		if (facadeUrl == null) {
			facadeUrl = getProperty(FACADE_URL_PROP);
		}
		return facadeUrl;
	}

	/**
	 * @return the photoTmpDirectory
	 */
	public String getPhotoTmpDirectory() {
		if (photoTmpDirectory == null) {
			photoTmpDirectory = getProperty(PHOTO_TMP_DIR);
		}
		return photoTmpDirectory;
	}

}
