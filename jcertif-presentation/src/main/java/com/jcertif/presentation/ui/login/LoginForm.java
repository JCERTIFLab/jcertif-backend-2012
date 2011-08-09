package com.jcertif.presentation.ui.login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.data.bo.participant.ProfilUtilisateur;
import com.jcertif.presentation.internationalisation.Msg;
import com.jcertif.presentation.wsClient.ParticipantClient;
import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Link;
import com.vaadin.ui.VerticalLayout;

/**
 * Login Form.
 * 
 * @author rossi
 * 
 */
public class LoginForm extends Form {

    private static final Object[] VISIBLE_PROPERTIES = new Object[]{"id", "password"};
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginForm.class);
    private Button loginButton;
    private Button forgetPasswordLink;

    public LoginForm() {
	super();
	init();
    }

    private void init() {
	LOGGER.info("Initialize Login Form");
	this.getLayout().setMargin(true);
	setFormFieldFactory(new LoginFieldFactory());
	LoginBean loginBean = new LoginBean();
	BeanItem<LoginBean> item = new BeanItem<LoginBean>(loginBean);
	this.setItemDataSource(item);
	this.setVisibleItemProperties(VISIBLE_PROPERTIES);
	this.setCaption(Msg.get("ui.login.title"));

	// Login Button
	HorizontalLayout layoutFooter = new HorizontalLayout();
	layoutFooter.setMargin(true);
	layoutFooter.addComponent(getLoginButton());
	layoutFooter.addComponent(getForgetPasswordLink());

	this.setFooter(layoutFooter);
    }

    /**
     * Commit the form, check id/password and return participant.
     * 
     * @return participant if id/password is valid, null otherwise
     */
    public Participant commitAndGetParticipant() {
	super.commit();

	boolean isvalid = false;

	Participant participant = ParticipantClient.getInstance().findByEmail(
		(String) this.getField("id").getValue());

	if (participant != null) {
	    ProfilUtilisateur profil = participant.getProfilUtilisateur();

	    if (getEncodedPassword(((String) this.getField("password").getValue())).equals(
		    profil.getPassword())) {
		isvalid = true;
	    }
	}

	if (!isvalid) {
	    this.setComponentError(new UserError(Msg.get("ui.login.invalid.error")));
	    return null;
	}

	return participant;
    }

    public void generateNewPassword() {
	try {
	    this.getField("id").commit();
	    final String email = (String) this.getField("id").getValue();
	    Participant participant = ParticipantClient.getInstance().findByEmail(
		    email);

	    if (participant == null) {
		this.setComponentError(new UserError(Msg.get("ui.login.emailnotfound.error")));
	    } else {
		ParticipantClient.getInstance().generateNewPassword(email);
	    }
	} catch (Exception e) {
	    this.setComponentError(new UserError(Msg.get("ui.login.emailinvalid.error")));
	}




    }

    public void clearForm() {
	this.getField("id").setValue(null);
	this.getField("password").setValue(null);
	this.setComponentError(null);
	this.fireComponentErrorEvent();
    }

    public String getEncodedPassword(String key) {
	byte[] uniqueKey = key.getBytes();
	byte[] hash = null;
	try {
	    hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
	} catch (NoSuchAlgorithmException e) {
	    throw new RuntimeException(e);
	}
	StringBuilder hashString = new StringBuilder();
	for (int i = 0; i < hash.length; ++i) {
	    hashString.append(hash[i]);
	}
	return hashString.toString();
    }

    /**
     * @return the loginButton
     */
    public Button getLoginButton() {
	if (loginButton == null) {
	    loginButton = new Button(Msg.get("ui.login.button"));
	}
	return loginButton;
    }

    public Button getForgetPasswordLink() {
	if (forgetPasswordLink == null) {
	    forgetPasswordLink = new Button(Msg.get("ui.login.forgetpassword"));
	    forgetPasswordLink.setStyleName("link");
	}
	return forgetPasswordLink;
    }
}
