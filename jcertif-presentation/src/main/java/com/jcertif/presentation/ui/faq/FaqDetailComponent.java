package com.jcertif.presentation.ui.faq;

import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.conference.Faq;
import com.jcertif.presentation.ui.util.UIConst;
import com.jcertif.presentation.wsClient.FaqClient;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

/**
 * Foire aux questions details Panel.
 * 
 * @author Max
 * 
 */
public class FaqDetailComponent extends Panel {

	private static final long serialVersionUID = 1L;

	/**
	 * A Logger for class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(FaqDetailComponent.class);

	/**
	 * A constructor.
	 * 
	 * @param event
	 *            a event
	 */
	public FaqDetailComponent() {
		super();
		update();
		this.addStyleName("event_details_panel");
	}

	/**
	 * Update de details.
	 * 
	 * @param event
	 *            a event
	 */
	public void update() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Updating Detail Panel with FAQ");
		}
		// this.removeAllComponents();

		for (Faq faq : getFaqList()) {

			CustomLayout htmlLayout = new CustomLayout(UIConst.CALENDAR_DETAIL_LAYOUT);
			htmlLayout.addStyleName("details_event_layout");

			// Sujet
			htmlLayout.addComponent(new Label("Foire aux Questions"));

			// Lastname + firstname
			htmlLayout.addComponent(new Label(faq.getQuestion()), "presentateur");
			// Participant Bio
			htmlLayout.addComponent(new Label(faq.getReponse()), "details");

			// Use it as the layout of the Panel.
			this.addComponent(htmlLayout);
		}

	}

	public static String getFacadeURL() {
		ResourceBundle bundle = ResourceBundle.getBundle(UIConst.WEBAPP_PROPERTIES_FILE);
		return bundle.getString(UIConst.FACADE_URL_PROP);
	}

	// Set<Evenement> boEvents = new
	// HashSet<Evenement>(EvenementClient.getInstance()
	// .findAllXML());

	// Récupération des partenaires
	private Set<Faq> getFaqList() {
		Set<Faq> faqs = new HashSet<Faq>(FaqClient.getInstance().findAllXML());
		return faqs;
	}

}
