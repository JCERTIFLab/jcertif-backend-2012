package com.jcertif.presentation.ui.faq;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.conference.Faq;
import com.jcertif.presentation.internationalisation.Msg;
import com.jcertif.presentation.ui.util.UIConst;
import com.jcertif.presentation.ui.util.UIStyle;
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
	private boolean isFirsTime = true;
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
		this.addStyleName(UIStyle.COMMON_DETAILS_PANEL);
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

			CustomLayout htmlLayout = new CustomLayout(UIConst.COMMUN_DETAIL_LAYOUT);
			htmlLayout.addStyleName(UIStyle.DETAILS_COMMON_LAYOUT);

			// Sujet
			if (isFirsTime) {
				htmlLayout.addComponent(new Label(Msg.get("ui.faq.title")), "caption");
				htmlLayout.addComponent(new Label(Msg.get("ui.faq.description")),
						"captionDetail");
			}

			// Lastname + firstname
			htmlLayout.addComponent(new Label(faq.getQuestion()), "presentateur");
			// Participant Bio
			htmlLayout.addComponent(new Label(faq.getReponse()), "details");

			// Use it as the layout of the Panel.
			this.addComponent(htmlLayout);
			isFirsTime = false;
		}

	}

	// Récupération des partenaires
	private Set<Faq> getFaqList() {
		Set<Faq> faqs = new HashSet<Faq>(FaqClient.getInstance().findAllXML());
		return faqs;
	}

}
