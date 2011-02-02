/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel;

import com.jcertif.presentation.action.AbstractAction;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.SplitPanel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Runo;
import java.util.Set;

/**
 *
 * @author Douneg
 */
public abstract class MasterDetailsPanel<PA extends AbstractAction> extends Panel {

    private PA action;

    public MasterDetailsPanel(PA action) {
        this.action = action;
        setSizeFull();
        addStyleName(Runo.PANEL_LIGHT);
        getContent().setSizeFull();
    }

    Panel buildPanel(String panelTitle, Component piece) {
        Panel localPanel = new Panel(panelTitle, new VerticalLayout());
        localPanel.setSizeFull();
        localPanel.addStyleName(Runo.PANEL_LIGHT);
        localPanel.getContent().setSizeFull();
        localPanel.addComponent(piece);
        return localPanel;
    }

    Layout buildMainPanel(String caption, String masterPanelTitle, Component masterPiece, Set<Button> buttonSet, Set<Component> detailsPanel) {
        AbsoluteLayout root = new AbsoluteLayout();
        root.setSizeFull();

        //   root.setCaption(caption);
        if (buttonSet != null) {
            HorizontalLayout buttons = (HorizontalLayout) buildButtonPanel(buttonSet);
            root.addComponent(buttons, "top: 11px; right: 18px; z-index:1;");
        }
        SplitPanel content = new SplitPanel(SplitPanel.ORIENTATION_VERTICAL);
        content.setSizeFull();
        root.addComponent(content);

        if (masterPiece != null) {
            Panel master = buildPanel(masterPanelTitle, masterPiece);
            content.setFirstComponent(master);
        } else {
            content.setLocked(true);
            content.setSplitPosition(0);
        }
        if (detailsPanel != null) {
            VerticalLayout detailPanel = (VerticalLayout) buildDetailsPanel(detailsPanel);
            content.setSecondComponent(detailPanel);
        } else {
            content.setLocked(true);
            content.setSplitPosition(100);
        }
        if (masterPiece != null & detailsPanel != null) {
            content.setLocked(false);
            content.setSplitPosition(50);
        }
        return root;
    }

    Layout buildDetailPanel(String caption, String masterPanelTitle, Component detailPiece, Set<Button> buttonSet) {
        AbsoluteLayout root = new AbsoluteLayout();
        root.setSizeFull();
        root.setCaption(caption);
       
        if (buttonSet != null) {
            HorizontalLayout buttons = (HorizontalLayout) buildButtonPanel(buttonSet);
            root.addComponent(buttons, "top: 11px; right: 18px; z-index:1;");
        }
        if (detailPiece != null) {
            Panel master = buildPanel(masterPanelTitle, detailPiece);
            root.addComponent(master);
        }

        return root;
    }

    Layout buildDetailPanel(String caption, String masterPanelTitle, Component detailPiece) {
        AbsoluteLayout root = new AbsoluteLayout();
        root.setSizeFull();
        root.setCaption(caption);
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        root.addComponent(content);
        Panel detail = buildPanel(masterPanelTitle, detailPiece);
        content.addComponent(detail);
        return root;
    }

    Layout buildDetailsPanel(Set<Component> detailsPanel) {
        VerticalLayout detailPanelLocal = new VerticalLayout();
        detailPanelLocal.setMargin(true);
        detailPanelLocal.setSpacing(true);
        detailPanelLocal.setSizeFull();
        detailPanelLocal.addStyleName(Runo.LAYOUT_DARKER);
        TabSheet detailsSheet = new TabSheet();
        detailsSheet.setStyleName(Runo.TABSHEET_SMALL);
        for (Component component : detailsPanel) {
            detailsSheet.addComponent(component);
        }
        detailsSheet.setSizeFull();
        detailPanelLocal.addComponent(detailsSheet);
        return detailPanelLocal;
    }

    Layout buildButtonPanel(Set<Button> buttonList) {
        HorizontalLayout buttonsLocal = new HorizontalLayout();
        buttonsLocal.setSpacing(true);
        for (Button button : buttonList) {
            button.setStyleName(Runo.LAYOUT_DARKER);
            buttonsLocal.addComponent(button);
        }
        return buttonsLocal;
    }

    public PA getAction() {
        return action;
    }
}
