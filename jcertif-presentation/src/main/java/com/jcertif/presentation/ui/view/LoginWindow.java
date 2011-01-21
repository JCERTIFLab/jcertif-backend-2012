package com.jcertif.presentation.ui.view;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.JCertifWebApplication;
import com.jcertif.presentation.data.RestApiException;

import com.vaadin.data.validator.EmailValidator;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.BaseTheme;

public class LoginWindow extends Window implements Button.ClickListener {

    private static final long serialVersionUID = 5020323273015528048L;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private TextField activateFirstName;
    private TextField activateLastName;
    private TextField activateEmail;
    private Button activateButton;
    private Label activateDoneLabel;
    private Label activateInstructionsLabel;
    private Button showActivateButton;

    private TextField signInEmail;
    private TextField signInActivationCode;
    private Button signInButton;
    private Label signInInstructionsLabel;
    private CheckBox signInStoreCookie;

    private VerticalLayout activateLayout;
    private VerticalLayout signInLayout;

    public LoginWindow() {
        super("Sign in to MySchedule");
        setStyleName("login-window");
        setModal(true);
        setWidth("235px");
        setResizable(false);
        setContent(createLayout());
        signInEmail.focus();
        setCloseShortcut(KeyCode.ESCAPE);
    }

    private Layout createLayout() {

        // create all required fields
        activateInstructionsLabel = new Label("Activate MySchedule by providing your name and e-mail address. "
                + "After activation you'll receive an activation code to the given e-mail address.");
        activateFirstName = createTextField("First Name");
        activateLastName = createTextField("Last Name");
        activateEmail = createTextField("E-mail");
        activateEmail.addValidator(new EmailValidator("Not a valid e-mail address"));
        activateButton = new Button("Activate", this);
        activateDoneLabel = new Label(
                "<strong>Activation code sent!</strong> Check your inbox and copy the code to the field below and you're ready to go.",
                Label.CONTENT_XHTML);
        activateDoneLabel.setVisible(false);

        signInEmail = createTextField("E-mail");
        signInEmail.addValidator(new EmailValidator("Not a valid e-mail address"));
        signInActivationCode = createTextField("Activation Code");
        signInButton = new Button("Sign In", this);
        signInButton.setClickShortcut(KeyCode.ENTER);
        signInInstructionsLabel = new Label("Sign in by providing your e-mail address and activation code.");
        signInStoreCookie = new CheckBox("Remember me");
        signInStoreCookie.setValue(true);
        showActivateButton = new Button("Don't yet have an activation code?", this);
        showActivateButton.setStyleName(BaseTheme.BUTTON_LINK);

        // add the created fields to a Layout
        final Layout layout = new VerticalLayout();

        signInLayout = new VerticalLayout();
        signInLayout.setSpacing(true);
        signInLayout.setSizeFull();
        signInLayout.setStyleName("sign-in");
        signInLayout.addComponent(activateDoneLabel);
        signInLayout.addComponent(signInInstructionsLabel);
        signInLayout.addComponent(signInEmail);
        signInLayout.addComponent(signInActivationCode);
        signInLayout.addComponent(signInStoreCookie);
        signInLayout.addComponent(signInButton);
        signInLayout.addComponent(showActivateButton);
        layout.addComponent(signInLayout);

        activateLayout = new VerticalLayout();
        activateLayout.setSpacing(true);
        activateLayout.setSizeFull();
        activateLayout.setStyleName("activate");
        activateLayout.setVisible(false);
        activateLayout.addComponent(activateInstructionsLabel);
        activateLayout.addComponent(activateFirstName);
        activateLayout.addComponent(activateLastName);
        activateLayout.addComponent(activateEmail);
        activateLayout.addComponent(activateButton);
        layout.addComponent(activateLayout);

        return layout;
    }

    private TextField createTextField(final String caption) {
        final TextField field = new TextField(caption);
        field.setValidationVisible(false);
        field.setRequired(true);
        field.setRequiredError("Required field");
        field.setWidth("100%");
        return field;
    }

    public void buttonClick(final ClickEvent event) {
        try {
            if (event.getButton() == signInButton) {
                doSignIn();
            } else if (event.getButton() == activateButton) {
                doActivate();
            } else if (event.getButton() == showActivateButton) {
                showActivateLayout();
            }
        } catch (final RestApiException e) {
            logger.error(e.getMessage(), e);
            getWindow().showNotification(e.getMessage(), Notification.TYPE_ERROR_MESSAGE);
        }
    }

    private void showActivateLayout() {
        activateLayout.setVisible(true);
        activateButton.setClickShortcut(KeyCode.ENTER);
        signInLayout.setVisible(false);
        signInButton.removeClickShortcut();
        activateFirstName.focus();
    }

    private void hideActivateLayout() {
        activateLayout.setVisible(false);
        activateButton.removeClickShortcut();
        signInLayout.setVisible(true);
        signInButton.setClickShortcut(KeyCode.ENTER);
    }

    private void doActivate() throws RestApiException {
        activateEmail.setValidationVisible(true);
        activateFirstName.setValidationVisible(true);
        activateLastName.setValidationVisible(true);
        if (!activateEmail.isValid() || !activateFirstName.isValid() || !activateLastName.isValid()) {
            return;
        }

        final JCertifWebApplication app = JCertifWebApplication.getCurrentInstance();

        // tell the backend to do the activation
        app.getBackendFacade().activateMySchedule((String) activateFirstName.getValue(),
                (String) activateLastName.getValue(), (String) activateEmail.getValue());

        // hide the activation fields and show sign in fields again
        hideActivateLayout();

        // show further instructions and copy the e-mail to sign in field
        activateDoneLabel.setVisible(true);
        signInEmail.setValue(activateEmail.getValue());
    }

    private void doSignIn() throws RestApiException {
        signInEmail.setValidationVisible(true);
        signInActivationCode.setValidationVisible(true);
        if (!signInEmail.isValid() || !signInActivationCode.isValid()) {
            return;
        }

        final JCertifWebApplication app = JCertifWebApplication.getCurrentInstance();

        if (app.doSignIn((String) signInEmail.getValue(), (String) signInActivationCode.getValue())) {
            // store cookie if remember me was checked
            if (signInStoreCookie.booleanValue()) {
                app.storeUserCookie();
            }

            // close this modal window
            close();
        } else {
            // invalid user
            getWindow().showNotification("Could not sign in. Check the e-mail and activation code.",
                    Notification.TYPE_ERROR_MESSAGE);
        }
    }
}
