package com.jcertif.presentation.ui.inscription.complement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.internationalisation.Msg;
import com.jcertif.presentation.ui.util.ComponentFactory;
import com.jcertif.presentation.ui.util.JCertifProps;
import com.jcertif.presentation.ui.util.UIConst;
import com.jcertif.presentation.ui.util.UIStyle;
import com.vaadin.terminal.FileResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Window;

/**
 * Complement form.
 * 
 * @author rossi.oddet
 * 
 */
public class ComplementForm extends Window implements Receiver, Upload.SucceededListener,
		Upload.FailedListener {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory.getLogger(ComplementForm.class);

	private TextField bioTx;

	private Upload photoUpload;

	private File file;

	private Button validateBt;

	public ComplementForm() {
		super();
		init();
	}

	private void init() {
		this.setCaption(Msg.get("ui.inscription.complement.title"));
		this.setContent(new FormLayout());
		this.setStyleName(UIStyle.COMPLEMENT_WINDOW);
		// this.addComponent(new
		// Label(Messages.getString("inscription.complement.title")));
		reinit(null);
	}

	/**
	 * 
	 */
	private void reinit(Component photoUploaded) {
		this.removeAllComponents();
		this.addComponent(getBioTx());
		this.addComponent(getPhotoUpload());
		if (photoUploaded != null) {
			this.addComponent(photoUploaded);
		}
		this.addComponent(getValidateBt());
	}

	/**
	 * @return the bioTx
	 */
	public TextField getBioTx() {
		if (bioTx == null) {
			bioTx = ComponentFactory
					.createTextField(Msg.get("ui.inscription.complement.bio"), true);
			bioTx.setRows(5);
			bioTx.setColumns(30);
		}
		return bioTx;
	}

	/**
	 * @return the photoUpload
	 */
	public Upload getPhotoUpload() {
		if (photoUpload == null) {
			photoUpload = new Upload(Msg.get("ui.inscription.complement.upload.text"), this);
			photoUpload.setButtonCaption(Msg.get("ui.inscription.complement.upload.button"));
			photoUpload.addListener((Upload.SucceededListener) this);
			photoUpload.addListener((Upload.FailedListener) this);

		}
		return photoUpload;
	}

	/**
	 * @return the validateBt
	 */
	public Button getValidateBt() {
		if (validateBt == null) {
			validateBt = new Button(Msg.get("ui.inscription.complement.valider.button"));
		}
		return validateBt;
	}

	public File getFile() {
		return file;
	}

	@Override
	public OutputStream receiveUpload(String filename, String MIMEType) {
		FileOutputStream fos = null;
		String photoTmp = JCertifProps.getInstance().getPhotoTmpDirectory();

		if (photoTmp.startsWith(UIConst.TOMCAT_DIR_VARIABLE)) {
			photoTmp = photoTmp.replace(UIConst.TOMCAT_DIR_VARIABLE,
					System.getProperty(UIConst.TOMCAT_DIR_VARIABLE));
		}

		File tmpDir = new File(photoTmp);

		if (!tmpDir.exists()) {
			tmpDir.mkdirs();
		}

		file = new File(tmpDir,
				new SimpleDateFormat(UIConst.PHOTO_SUFFIX_PATTERN).format(new Date()) + filename);
		try {
			fos = new FileOutputStream(file);
		} catch (final java.io.FileNotFoundException e) {
			LOGGER.error("Erreur cr�ation fichier", e);
			this.addComponent(new Label("Erreur " + e + " message=" + e.getMessage()));
			this.addComponent(new Label("catalina dir path  "
					+ new File(System.getProperty("catalina.base")).getAbsolutePath()));
			return null;
		}

		return fos;
	}

	// This is called if the upload is finished.
	public void uploadSucceeded(Upload.SucceededEvent event) {
		final FileResource imageResource = new FileResource(file, getApplication());
		reinit(new Embedded("", imageResource));
	}

	// This is called if the upload fails.
	public void uploadFailed(Upload.FailedEvent event) {
		// Log the failure on screen.
		this.addComponent(new Label("Uploading " + event.getFilename() + " of type '"
				+ event.getMIMEType() + "' failed. exception :" + event.getReason()));
	}

	public boolean isValid() {
		return file != null && getBioTx().getValue() != null && !"".equals(getBioTx().getValue());
	}

	public void reinitComplementBean() {
		getBioTx().setValue("");
		file = null;
		reinit(null);

	}

}