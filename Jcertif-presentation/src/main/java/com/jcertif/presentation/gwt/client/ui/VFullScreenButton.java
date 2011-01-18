package com.jcertif.presentation.gwt.client.ui;

import com.google.gwt.dom.client.BodyElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Window;
import com.vaadin.terminal.gwt.client.ui.VButton;

public class VFullScreenButton extends VButton {

    private Element previousAppParent;

    @Override
    public void onClick(final ClickEvent event) {
        if (previousAppParent == null) {
            doFullScreen();
        } else {
            doRestore();
        }

        super.onClick(event);
    }

    private Element getAppRootElement() {
        String rootId = client.getConfiguration().getRootPanelId();
        return Document.get().getElementById(rootId);
    }

    private void doFullScreen() {
        final Element rootElement = getAppRootElement();
        final BodyElement bodyElement = Document.get().getBody();

        if (!rootElement.getParentElement().equals(bodyElement)) {
            // Detach the application from possible container div and store
            // the parent for restoring.
            previousAppParent = rootElement.getParentElement();
            bodyElement.appendChild(rootElement);
            setFullScreenStyle(rootElement);

            client.updateVariable(id, "fullscreen", true, false);
            client.forceLayout();

            // scroll to top to reveal the all of the application
            Window.scrollTo(0, 0);
        }
    }

    private void doRestore() {
        if (previousAppParent != null) {
            final Element rootElement = getAppRootElement();
            previousAppParent.appendChild(rootElement);
            setRestoredStyle(rootElement);
            previousAppParent = null;

            client.updateVariable(id, "fullscreen", false, false);
            client.forceLayout();
        }
    }

    private void setFullScreenStyle(final Element rootElement) {
        rootElement.getStyle().setPosition(Position.ABSOLUTE);
        rootElement.getStyle().setTop(0, Unit.PX);
        rootElement.getStyle().setLeft(0, Unit.PX);
        rootElement.getStyle().setWidth(100, Unit.PCT);
        rootElement.getStyle().setHeight(100, Unit.PCT);

        Document.get().getBody().getStyle().setWidth(100, Unit.PCT);
        Document.get().getBody().getStyle().setHeight(100, Unit.PCT);
        Document.get().getBody().getStyle().setOverflow(Overflow.HIDDEN);
        Document.get().getBody().addClassName("v-full-screen");

    }

    private void setRestoredStyle(final Element rootElement) {
        rootElement.getStyle().clearPosition();
        rootElement.getStyle().clearTop();
        rootElement.getStyle().clearLeft();
        rootElement.getStyle().clearWidth();
        rootElement.getStyle().clearHeight();

        Document.get().getBody().getStyle().clearWidth();
        Document.get().getBody().getStyle().clearHeight();
        Document.get().getBody().getStyle().clearOverflow();
        Document.get().getBody().removeClassName("v-full-screen");
    }
}
