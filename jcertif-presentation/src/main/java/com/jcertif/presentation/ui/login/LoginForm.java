package com.jcertif.presentation.ui.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.internationalisation.Messages;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;

/**
 * @author rossi
 * 
 */
public class LoginForm extends Form {

	private static final Object[] VISIBLE_PROPERTIES = new Object[] { "id", "password" };
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginForm.class);
	private Button loginButton;

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
		this.setCaption(Messages.getString("login.titre"));

		// Login Button
		HorizontalLayout layoutFooter = new HorizontalLayout();
		layoutFooter.addComponent(getLoginButton());
		this.setFooter(layoutFooter);
	}

	/**
	 * @return the loginButton
	 */
	public Button getLoginButton() {
		if (loginButton == null) {
			loginButton = new Button(Messages.getString("login.button"));
		}
		return loginButton;
	}

}
