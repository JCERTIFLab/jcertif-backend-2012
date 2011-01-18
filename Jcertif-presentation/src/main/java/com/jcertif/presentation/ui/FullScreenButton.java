package com.jcertif.presentation.ui;

import java.util.Map;

import com.vaadin.ui.Button;
import com.vaadin.ui.ClientWidget;

/**
 * Extended Button with additional client-side logic. This button allows full
 * screening and restoring a Vaadin application that is embedded inside a div
 * element.
 */
@ClientWidget(com.jcertif.presentation.gwt.client.ui.VFullScreenButton.class)
public class FullScreenButton extends Button {

    private static final long serialVersionUID = -1110596384418541526L;

    private boolean fullScreen = false;

    public FullScreenButton(final boolean initialFullScreen) {
        setStyleName("full-screen");
        setDescription("Toggle full screen mode");
        fullScreen = initialFullScreen;
    }

    @Override
    public void changeVariables(final Object source, final Map<String, Object> variables) {
        super.changeVariables(source, variables);
        if (variables.containsKey("fullscreen")) {
            fullScreen = (Boolean) variables.get("fullscreen");
        }
    }

    public boolean isFullScreen() {
        return fullScreen;
    }

}
