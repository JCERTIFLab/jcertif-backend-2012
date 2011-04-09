package com.jcertif.presentation.principal;

import com.jcertif.presentation.ui.calendar.CalendarComponent;
import com.jcertif.presentation.ui.calendar.CalendarEventBeanProvider;
import com.sun.jersey.api.client.ClientResponse;
import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import java.io.File;
import java.util.ArrayList;
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

    /*
     *Patterns ThreadLocal qui permet l'acces a l'application a partir de l'exterieur
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
        Window w=new Window();
        CalendarComponent calendar = new CalendarComponent();
        calendar.setEventProvider(new CalendarEventBeanProvider());
        w.getContent().addComponent(calendar);
        setMainWindow(w);
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

    public static void showError(ClientResponse status, String description) {
        String statusDescription = null;
        if (status != null) {
            statusDescription = (Response.Status.fromStatusCode(status.getStatus()) != null) ? (Response.Status.fromStatusCode(status.getStatus()).getReasonPhrase()) : "";
        } else {
            statusDescription = "";
        }
        if (JCertifVaadinApplication.getInstance() != null && JCertifVaadinApplication.getInstance().getMainWindow() != null) {
            Window main = JCertifVaadinApplication.getInstance().getMainWindow();
            // Create a notification with default settings for a warning.
            Window.Notification notif = new Window.Notification(
                    "Erreur HTTP " + status.getStatus() + " ", "</br>"
                    + statusDescription + "</br>" + description,
                    Window.Notification.TYPE_ERROR_MESSAGE);
// Set the position.
            notif.setPosition(Window.Notification.POSITION_CENTERED_TOP);

// Let it stay there until the user clicks it
            notif.setDelayMsec(-1);
// Show it in the main window.
            main.showNotification(notif);
        }
    }

    public static void showError(String status, String description) {
        String statusDescription = null;
        if (status != null) {
            statusDescription = status;
        } else {
            statusDescription = "";
        }
        if (JCertifVaadinApplication.getInstance() != null && JCertifVaadinApplication.getInstance().getMainWindow() != null) {
            Window main = JCertifVaadinApplication.getInstance().getMainWindow();
            // Create a notification with default settings for a warning.
            Window.Notification notif = new Window.Notification(
                    "Erreur " + status + " ", "</br>"
                    + statusDescription + "</br>" + description,
                    Window.Notification.TYPE_ERROR_MESSAGE);
// Set the position.
            notif.setPosition(Window.Notification.POSITION_CENTERED_TOP);

// Let it stay there until the user clicks it
            notif.setDelayMsec(-1);
// Show it in the main window.
            main.showNotification(notif);
        }
    }
    private ArrayList<String> allImageName;

    public ArrayList<String> getAllImageName() {
        if (allImageName == null || allImageName.isEmpty()) {
            allImageName = getImageName();
        }
        return allImageName;
    }

    private ArrayList<String> getImageName() {
        ArrayList<String> imageNames = new ArrayList<String>();
        File mainDir = new File(JCertifVaadinApplication.getInstance().getContext().getBaseDirectory(), "pages");
        File baseDirectory = new File(mainDir, "mainslide_images");
        File[] listOfFiles = baseDirectory.listFiles();
        for (File file : listOfFiles) {
            imageNames.add(file.getName());
        }
        return imageNames;
    }
}
