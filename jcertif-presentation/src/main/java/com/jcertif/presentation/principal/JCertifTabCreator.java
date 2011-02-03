/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.principal;

import com.jcertif.presentation.util.H1;
import com.jcertif.presentation.util.Ruler;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Runo;

/**
 *
 * @author Douneg
 */
public class JCertifTabCreator {

    public static Layout createPrincipalTab(String caption, String titleText, Panel mainPanel) {
        VerticalLayout l = new VerticalLayout();
        l.setMargin(true);
        l.setSpacing(true);
        l.setCaption(caption);
        l.setStyleName(Runo.LAYOUT_DARKER);
        l.setSizeFull();
        CssLayout margin = new CssLayout();
        margin.setMargin(false);
        margin.setWidth("100%");
        l.addComponent(margin);
        H1 title = new H1(titleText);
        margin.addComponent(title);
        margin.addComponent(new Ruler());
        l.addComponent(mainPanel);
        l.setExpandRatio(mainPanel, 1);
        return l;

    }
}
