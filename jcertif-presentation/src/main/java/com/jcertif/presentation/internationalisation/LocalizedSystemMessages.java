package com.jcertif.presentation.internationalisation;

import java.util.Locale;

import com.vaadin.Application;
import com.vaadin.Application.CustomizedSystemMessages;

/**
 * CustomizedSystemMessages extension that relies on a properties file.
 * This class also maintains the language for each user, so that different users
 * can get the message in their own language (once the session is under way).
 * 
 */
public class LocalizedSystemMessages extends CustomizedSystemMessages {
	private static final long serialVersionUID = 295825699005962978L;
	
	/**
	 * Locale associated with the current thread 
	 * (ThreadLocal maintains a map from the thread an associated value so there is in effect
	 * one thread Locale per thread.)
	 */
	static ThreadLocal<Locale> threadLocale = new ThreadLocal<Locale>();
	
	/**
	 * Sets the default language used for system messages emitted before the application
	 * has fully initialized, for example on a server restart.
	 * This will happen if the system message is issued before {@link #setThreadLocale(Locale)}
	 * has been called by the application (normally in an override of {@link Application#init()}.
	 * 
	 * Override this method if the JVM default locale (often en_US if running on a server) is
	 * inappropriate.
	 *  
	 * @return locale for messages issued before the Application has set its own locale.
	 */
	protected Locale getDefaultSystemMessageLocale() {
		return Locale.getDefault();
	}

	
	/**
	 * Called by the application if it wishes to have its LocalizedSystemMessages shown in the user's
	 * language.
	 * @param application
	 * @param locale
	 */
	public void setThreadLocale(Locale locale) {
		threadLocale.set(locale);
	}
	
	/**
	 * Get the application's current locale.
	 * @param application
	 * @return locale for the application
	 */
	public Locale getThreadLocale() {
		Locale loc = threadLocale.get();
		if (loc == null) {
			return getDefaultSystemMessageLocale();
		} else {
			return loc;
		}
	}


	/* (non-Javadoc)
	 * @see com.vaadin.Application.SystemMessages#getCommunicationErrorCaption()
	 */
	@Override
    public String getCommunicationErrorCaption() {
        return (communicationErrorNotificationEnabled ? 
        		Msg.getString("ui.message.system.communicationError.title", getThreadLocale()) //$NON-NLS-1$
                : null);
    }

	/* (non-Javadoc)
	 * @see com.vaadin.Application.SystemMessages#getCommunicationErrorMessage()
	 */
	@Override
    public String getCommunicationErrorMessage() {
        return (communicationErrorNotificationEnabled ? 
        		Msg.getString("ui.message.system.communicationError.message", getThreadLocale()) //$NON-NLS-1$
                : null);
    }
    

	/* (non-Javadoc)
	 * @see com.vaadin.Application.SystemMessages#getInternalErrorCaption()
	 */
	@Override
    public String getInternalErrorCaption() {
        return (internalErrorNotificationEnabled ? 
        		Msg.getString("ui.message.system.internalError.title", getThreadLocale()) //$NON-NLS-1$
                : null);
    }

	/* (non-Javadoc)
	 * @see com.vaadin.Application.SystemMessages#getInternalErrorMessage()
	 */
	@Override
    public String getInternalErrorMessage() {
        return (internalErrorNotificationEnabled ? 
        		Msg.getString("ui.message.system.internalError.message", getThreadLocale()) //$NON-NLS-1$
                : null);
    }


    /* (non-Javadoc)
     * @see com.vaadin.Application.SystemMessages#getOutOfSyncCaption()
     */
    @Override
	public String getOutOfSyncCaption() {
        return (outOfSyncNotificationEnabled ? 
        		Msg.getString("ui.message.system.outOfSync.title", getThreadLocale()) //$NON-NLS-1$
        		: null);
    }

    /**
     * @return the notification message, or null for no message
     */
	@Override
    public String getOutOfSyncMessage() {
        return (outOfSyncNotificationEnabled ? 
        		Msg.getString("ui.message.system.outOfSync.message", getThreadLocale()) //$NON-NLS-1$
        		: null);
    }
    

	/* (non-Javadoc)
	 * @see com.vaadin.Application.SystemMessages#getSessionExpiredCaption()
	 */
	@Override
    public String getSessionExpiredCaption() {
        return (sessionExpiredNotificationEnabled ? 
        		Msg.getString("ui.message.system.sessionExpired.title", getThreadLocale()) //$NON-NLS-1$
                : null);
    }


	/* (non-Javadoc)
	 * @see com.vaadin.Application.SystemMessages#getSessionExpiredMessage()
	 */
	@Override
    public String getSessionExpiredMessage() {
        return (sessionExpiredNotificationEnabled ? 
        		Msg.getString("ui.message.system.sessionExpired.message", getThreadLocale()) //$NON-NLS-1$
                : null);
    }
}
