package com.jcertif.presentation.principal;

import com.jcertif.presentation.wsClient.AbstractJCertWebServiceClient;
import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Main Application Vaadin for JCertif.
 * 
 * @author Douneg
 * 
 */
public class JCertifVaadinApplication extends Application implements HttpServletRequestListener {

    /*Patterns ThreadLocal qui permet l'acces a l'application apartir de l'exterieur
     */
    private static ThreadLocal<JCertifVaadinApplication> threadLocal = new ThreadLocal<JCertifVaadinApplication>();
    private static final long serialVersionUID = 1L;
    private MainWindow main;

    public MainWindow getMain() {
        AbstractJCertWebServiceClient ajcwsc = new AbstractJCertWebServiceClient(null) {
        };
        ajcwsc.checkConnection();
        if (main == null) {
            main = new MainWindow();
        }
        return main;
    }

    @SuppressWarnings("serial")
    @Override
    public void init() {
        setInstance(this); // So that we immediately have access to the current application
        setTheme("jcertifruno");
        setMainWindow(getMain());
    }

    // @return the current application instance
    public static JCertifVaadinApplication getInstance() {
        return threadLocal.get();
    }

    // Set the current application instance
    public static void setInstance(JCertifVaadinApplication application) {
        if (getInstance() == null) {
            threadLocal.set(application);
        }
    }

    @Override
    public void onRequestStart(HttpServletRequest request, HttpServletResponse response) {
        JCertifVaadinApplication.setInstance(this);
    }

    @Override
    public void onRequestEnd(HttpServletRequest request, HttpServletResponse response) {
        threadLocal.remove();
    }
}
