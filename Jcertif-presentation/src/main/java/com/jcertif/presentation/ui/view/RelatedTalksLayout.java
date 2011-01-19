package com.jcertif.presentation.ui.view;

import java.util.List;

import com.jcertif.presentation.JCertifWebApplication;
import com.jcertif.presentation.data.domain.JCertifPresentation;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.BaseTheme;

/**
 * Layout for displaying talks related to a single tag assignable via the
 * {@link #setTag(String, JCertifPresentation)} method.
 */
public class RelatedTalksLayout extends CssLayout implements Button.ClickListener {

    private static final long serialVersionUID = -8231650018794943524L;

    private final MainView mainView;

    public RelatedTalksLayout(final MainView mainView) {
        this.mainView = mainView;
        setWidth("100%");
        setStyleName("related-talks");
    }

    /**
     * Set the tag to display related talks for excluding the given talk.
     * 
     * @param tag
     * @param exclude
     */
    public void setTag(final String tag, final JCertifPresentation exclude) {
        final List<JCertifPresentation> related = JCertifWebApplication.getCurrentInstance().getBackendFacade()
                .search(tag);
        removeAllComponents();

        boolean relatedTalksFound = false;
        for (final JCertifPresentation relatedTalk : related) {
            if (!relatedTalk.equals(exclude)) {
                relatedTalksFound = true;

                final Button relatedTalkButton = new Button(relatedTalk.getTitle(), this);
                relatedTalkButton.setStyleName(BaseTheme.BUTTON_LINK);
                relatedTalkButton.setData(relatedTalk.getId());
                addComponent(relatedTalkButton);
            }
        }

        // no other related talks found -> add sorry label
        if (!relatedTalksFound) {
            addComponent(new Label("Sorry, no other talks for keyword <i>" + tag + "</i>", Label.CONTENT_XHTML));
        }
    }

 
    public void buttonClick(final ClickEvent event) {
        mainView.selectPresentationWithId((Integer) event.getButton().getData());
    }

}
