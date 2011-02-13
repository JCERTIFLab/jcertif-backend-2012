package com.jcertif.presentation.principal;

import com.jcertif.presentation.wsClient.AbstractJCertWebServiceClient;
import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.Window;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

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

    public static void showError(Integer status) {
        String statusDescription = (Response.Status.fromStatusCode(status) != null) ? (Response.Status.fromStatusCode(status).getReasonPhrase()) : "";
        if (JCertifVaadinApplication.getInstance() != null && JCertifVaadinApplication.getInstance().getMainWindow() != null) {
            Window main = JCertifVaadinApplication.getInstance().getMainWindow();
            // Create a notification with default settings for a warning.
            Window.Notification notif = new Window.Notification(
                    "Erreur " + status,
                    statusDescription,
                    Window.Notification.TYPE_ERROR_MESSAGE);
// Set the position.
            notif.setPosition(Window.Notification.POSITION_TOP_LEFT);
// Let it stay there until the user clicks it
            notif.setDelayMsec(-1);
// Show it in the main window.
            main.showNotification(notif);
        }
    }
}
