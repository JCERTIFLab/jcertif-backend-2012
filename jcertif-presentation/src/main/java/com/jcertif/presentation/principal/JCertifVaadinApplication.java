package com.jcertif.presentation.principal;

import com.vaadin.Application;

/**
 * Main Application Vaadin for JCertif.
 * 
 * @author Douneg
 * 
 */
public class JCertifVaadinApplication extends Application {

    private static final long serialVersionUID = 1L;
    private MainWindow main;

    public MainWindow getMain() {
        if (main == null) {
            main = new MainWindow();
        }
        return main;
    }

    @SuppressWarnings("serial")
    @Override
    public void init() {
        setTheme("jcertifruno");
        setMainWindow(getMain());
    }
}
