/* 
 * Copyright ©2009 Jean-François Lamy
 * 
 * Licensed under the Apache Licence, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


package com.jcertif.presentation.internationalisation;

import java.util.Locale;

import com.vaadin.Application;
import com.vaadin.service.ApplicationContext.TransactionListener;

/**
 * Example application for using localized SystemMessages configured from a properties file.
 * @author jflamy
 */
@SuppressWarnings("serial")
public class LocalizedApplication extends Application {

	private static LocalizedSystemMessages localizedMessages;

	@Override
	public void init() {
		// change the system message language in case any are shown while "init" is running.
		LocalizedSystemMessages msg = (LocalizedSystemMessages) getSystemMessages();
		msg.setThreadLocale(this.getLocale());  // by default getLocale() comes from the user's browser.
		
		// the following defines what will happen before and after each http request.
        attachHttpRequestListener();
        
        // create the initial look.
		//buildMainLayout();
	}
	
    /**
     * Get localized SystemMessages for this application.
     * 
     * <p>This method is static; we need to call {@link LocalizedSystemMessages#setThreadLocale(Locale)}
     * to change the language that will be used for this thread. This is typically done in a
     * {@link TransactionListener#transactionStart(Application, Object)} method in order to associate
     * the Locale with the thread processing the HTTP request.</p>
     * 
     * @return the LocalizedSystemMessages for this application
     */
	public static SystemMessages getSystemMessages() {
    	if (localizedMessages == null)
    		localizedMessages = new LocalizedSystemMessages() {
				@Override
				protected Locale getDefaultSystemMessageLocale() {
					return Locale.FRENCH;
				}	
    	};
    	return localizedMessages;
    }
    
    /**
     * Attach a listener for the begin and end of every HTTP request in the session.
     * (Vaadin "transaction" equals "http request".)  
     */
    private void attachHttpRequestListener() {
        getContext().addTransactionListener(new TransactionListener() {
			private static final long serialVersionUID = 316709294485669937L;

			@Override
			public void transactionEnd(Application application, Object transactionData) {}

			@Override
			public void transactionStart(Application application, Object transactionData) {
				// force system messages to appear in user's lanquage
        		((LocalizedSystemMessages)getSystemMessages()).setThreadLocale(getLocale());
			}
        });
    }

}