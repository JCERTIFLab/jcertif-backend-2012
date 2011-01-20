package com.jcertif.presentation.ui.view;


import com.jcertif.presentation.data.domain.JCertifSpeaker;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.BaseTheme;

public class SpeakerDetails extends CssLayout implements Button.ClickListener {

    private static final long serialVersionUID = -7728513294006871293L;

    private Label detailsLabel;

    public SpeakerDetails(final JCertifSpeaker speaker) {
        setStyleName("speaker-details");

        final Button speakerButton = new Button(speaker.getName(), this);
        speakerButton.setData(speaker);
        speakerButton.setStyleName(BaseTheme.BUTTON_LINK);
        addComponent(speakerButton);
    }

    public void buttonClick(final ClickEvent event) {
        final JCertifSpeaker speaker = (JCertifSpeaker) event.getButton().getData();

        if (detailsLabel == null) {
            // opened for the first time
            detailsLabel = new Label("<p><img src=\"" + speaker.getImageUri()
                    + "\" alt=\"\" />" + speaker.getBio() + "</p>",
                    Label.CONTENT_XHTML);
            detailsLabel.setWidth("215px");

            event.getButton().addStyleName("open");
            addComponent(detailsLabel);
        } else {
            if (detailsLabel.isVisible()) {
                detailsLabel.setVisible(false);
                event.getButton().removeStyleName("open");
            } else {
                detailsLabel.setVisible(true);
                event.getButton().addStyleName("open");
            }
        }
    }
}
