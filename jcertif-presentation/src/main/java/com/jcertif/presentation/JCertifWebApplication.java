package com.jcertif.presentation;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import org.apache.log4j.Logger;
import com.jcertif.presentation.JCertifWebApplication;
import com.jcertif.presentation.data.RestApiException;
import com.jcertif.presentation.data.domain.MyScheduleUser;
import com.jcertif.presentation.ui.view.ScheduleGATracker;
import com.jcertif.presentation.ui.view.UnsupportedBrowserWindow;

import com.jcertif.presentation.data.CachingRestApiFacade;
import com.jcertif.presentation.data.RestApiFacade;
import com.jcertif.presentation.data.domain.JCertifPresentation;
import com.jcertif.presentation.ui.view.MainView;
import com.vaadin.Application;
import com.vaadin.service.ApplicationContext.TransactionListener;
import com.vaadin.terminal.gwt.server.WebApplicationContext;
import com.vaadin.terminal.gwt.server.WebBrowser;
import com.vaadin.ui.Window;
import org.vaadin.googleanalytics.tracking.GoogleAnalyticsTracker;
import org.vaadin.browsercookies.BrowserCookies;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class JCertifWebApplication extends Application implements TransactionListener, BrowserCookies.UpdateListener
{
    private static final String COOKIE_FIELD_SEPARATOR = ",";
    private static final long COOKIE_EXPIRATION_IN_MILLIS = 365 * 24 * 60 * 60 * 1000L;

    private static final Logger logger = Logger.getLogger(JCertifWebApplication.class);
    public static final String MY_SCHEDULE_USER_COOKIE = "MyScheduleUser";

    private static final long serialVersionUID = 1167695727109405960L;

    private static final CustomizedSystemMessages systemMessages;

	
    // Use the ThreadLocal pattern, for more details see:
    // http://vaadin.com/wiki/-/wiki/Main/ThreadLocal%20Pattern
    private static final ThreadLocal<JCertifWebApplication> currentApplication = new ThreadLocal<JCertifWebApplication>();

    private transient RestApiFacade backendFacade;

    private BrowserCookies cookies;
    private GoogleAnalyticsTracker tracker;

    static {
        systemMessages = new CustomizedSystemMessages();

        // Disable session expired notification -> just restart the application
        // if the session expires.
        systemMessages.setSessionExpiredNotificationEnabled(false);
    }

    public static SystemMessages getSystemMessages() {
        return systemMessages;
    }

    @Override
    public String getVersion() {
        return VersionInformation.getVersion();
    }

 
    @Override
    public void init() {
        currentApplication.set(this);
        getContext().addTransactionListener(this);

        backendFacade = new CachingRestApiFacade();

        setMainWindow(createMainWindow());
       // setTheme("JCertif");
        //TO DO: Use this theme only when the final is ready. For now it'll crash, since not the theming is not yet there
    }

    
    private Window createMainWindow() {
        final Window mainWindow = new Window("JCertif 2011 App");

        // init Google Analytics tracker
        tracker = new ScheduleGATracker();

        final MainView mainView = new MainView();
        mainWindow.setContent(mainView);
        mainWindow.addURIHandler(mainView);

        checkBrowserSupport(mainWindow);

        // init cookie handling
        cookies = new BrowserCookies(true);
        cookies.addListener(this);
        mainWindow.addComponent(cookies);
        mainWindow.addComponent(tracker);

        return mainWindow;
    }

    
    /**
     * Track a page view with Google Analytics.
     * 
     * @param action
     *            name of the action to be tracked.
     * @param target
     *            target JCertifPresentation for the action (null allowed).
     */
    public static void trackPageview(final String action, final JCertifPresentation target) {
        String path = "/" + action;
        if (target != null) {
            try {
                path += "/" + target.getId() + "/" + URLEncoder.encode(target.getTitle(), "utf-8");
            } catch (final UnsupportedEncodingException ignored) {
                // should never happen
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Tracking page view: " + path);
        }

        getCurrentInstance().tracker.trackPageview(path);
    }

    public void storeUserCookie() {
        if (getUser() != null && getUser() instanceof MyScheduleUser) {
            final MyScheduleUser user = (MyScheduleUser) getUser();
            final String cookieData = user.getEmail() + COOKIE_FIELD_SEPARATOR + user.getActivationCode();
            final Date cookieExpiration = new Date(System.currentTimeMillis() + COOKIE_EXPIRATION_IN_MILLIS);

            cookies.setCookie(MY_SCHEDULE_USER_COOKIE, cookieData, cookieExpiration);
        }
    }

    public void doSignOut() {
        setUser(null);
        cookies.setCookie(MY_SCHEDULE_USER_COOKIE, "-", new Date(1));
    }

    //@Override
    public void cookiesUpdated(final BrowserCookies browserCookies) {
        final String myScheduleUser = browserCookies.getCookie(MY_SCHEDULE_USER_COOKIE);
        if (myScheduleUser != null && JCertifWebApplication.getCurrentInstance().getUser() == null) {
            final String[] userData = myScheduleUser.split(COOKIE_FIELD_SEPARATOR);
            if (userData.length == 2) {
                try {
                    doSignIn(userData[0], userData[1]);
                } catch (final RestApiException e) {
                    logger.error("Sign in from cookie data failed: " + e.getMessage(), e);
                }
            }
        }
    }

    private void checkBrowserSupport(final Window mainWindow) {
        if (getContext() instanceof WebApplicationContext) {
            final WebBrowser browser = ((WebApplicationContext) getContext()).getBrowser();

            if (!isSupportedBrowser(browser)) {
                mainWindow.addWindow(new UnsupportedBrowserWindow("http://jcertif.com"));
            }
        }
    }

    private boolean isSupportedBrowser(final WebBrowser browser) {
        return !(browser.isIE() && browser.getBrowserMajorVersion() <= 6);
    }

    public boolean doSignIn(final String email, final String activationCode) throws RestApiException {
        if (email == null || activationCode == null) {
            return false;
        }

        final MyScheduleUser newUser = new MyScheduleUser(email, activationCode);

        if (getBackendFacade().isValidUser(newUser)) {
            // valid user -> load the favourites for this user from the backend
            getBackendFacade().getScheduleForUser(newUser);

            // set the new user instance as the logged in user
            setUser(newUser);
            return true;
        }

        return false;
    }

    /**
     * Returns the facade for calling the backend methods for retrieving or
     * storing data.
     * 
     * @return the facade for calling the backend.
     */
    public RestApiFacade getBackendFacade() {
        return backendFacade;
    }

    /**
     * Returns the instance of this Application for the currently running Thread
     * for easy access to this instance.
     * 
     * @return instance of this Application for the currently running Thread.
     */
    public static JCertifWebApplication getCurrentInstance() {
        return currentApplication.get();
    }

    @Override
    public Window getWindow(final String name) {
        Window window = super.getWindow(name);
        if (window == null) {
            // support for multiple browser windows or tabs
            if (logger.isDebugEnabled()) {
                logger.debug("Creating new Window for name: " + name);
            }
            window = createMainWindow();
            window.setName(name);
            addWindow(window);
        }
        return window;
    }

    public void transactionStart(final Application application, final Object transactionData) {
        if (application == this) {
            // set the ThreadLocal value
            currentApplication.set(this);
        }
    }

    public void transactionEnd(final Application application, final Object transactionData) {
        if (application == this) {
            // remove the ThreadLocal value
            currentApplication.remove();
        }
    }


    
}
