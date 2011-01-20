package com.jcertif.presentation.ui.view;

import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 * Window that displays a message about unsupported browser and offers the user
 * to still try the application or navigate to the <code>retreatUrl</code> given
 * in the constructor.
 */
public class UnsupportedBrowserWindow extends Window implements ClickListener {

    private static final long serialVersionUID = -386641332433572754L;

    private Button ok;
    private Button cancel;
    private final String retreatUrl;

    public UnsupportedBrowserWindow(final String retreatUrl) {
        super("Warning");
        this.retreatUrl = retreatUrl;

        setModal(true);
        setWidth("350px");

        ok = new Button("I still want to try it.", this);
        cancel = new Button("Take me out of here", this);

        addComponent(new Label(
                "You're using an unsupported browser. "
                        + "This means that the application might not function or display correctly."));

        final HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setSpacing(true);
        buttonLayout.addComponent(cancel);
        buttonLayout.addComponent(ok);
        addComponent(buttonLayout);

    }

    public void buttonClick(final ClickEvent event) {
        if (event.getButton() == ok) {
            // simply close this window and let the application run
            close();
        } else if (event.getButton() == cancel) {
            getParent().getWindow().open(new ExternalResource(retreatUrl));
        }
    }

}
