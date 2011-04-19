/**
 * 
 */
package com.jcertif.presentation.ui.infosutiles;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.internationalisation.Msg;
import com.jcertif.presentation.ui.util.UIConst;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

/**
 * @author rossi
 * 
 */
public class InfosUtilesDetailComponent extends Panel {

	private static final String INFOSUTILES_PROP_PREFIX = "ui.infosutiles";
	private static final long serialVersionUID = 1L;

	/**
	 * A Logger for class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(InfosUtilesDetailComponent.class);

	/**
	 * A constructor.
	 * 
	 * @param event
	 *            a event
	 */
	public InfosUtilesDetailComponent() {
		super();
		update();
		this.addStyleName("commun_details_panel");
	}

	/**
	 * Update de details.
	 * 
	 * @param event
	 *            a event
	 */
	public void update() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Updating Detail Panel with InfosUtiles");
		}
		this.removeAllComponents();

		Map<String, String> allProps = Msg.getAllProps();

		Map<String, Map<String, String>> keyProps = new HashMap<String, Map<String, String>>();

		for (String key : allProps.keySet()) {

			if (key.startsWith(INFOSUTILES_PROP_PREFIX)) {
				String newKey = key.split("\\.")[2];

				if (keyProps.containsKey(newKey)) {
					keyProps.get(newKey).put(key, allProps.get(key));
				} else {
					keyProps.put(newKey, new HashMap<String, String>());
					keyProps.get(newKey).put(key, allProps.get(key));
				}

			}
		}

		String[] tabOrder = Msg.get("ui.infosutiles.sorting").split(",");

		// Entete
		CustomLayout htmlLayout = new CustomLayout(UIConst.COMMUN_DETAIL_LAYOUT);
		htmlLayout.addStyleName("details_commun_layout");
		htmlLayout.addComponent(new Label(Msg.get("ui.infosutiles.title")), "caption");
		htmlLayout.addComponent(new Label(Msg.get("ui.infosutiles.intro")), "captionDetail");
		this.addComponent(htmlLayout);
		for (String sort : tabOrder) {
			Map<String, String> props = keyProps.get(sort);

			if (props != null) {
				String title = props.get(INFOSUTILES_PROP_PREFIX + "." + sort + ".title");
				String desc = props.get(INFOSUTILES_PROP_PREFIX + "." + sort + ".description");

				CustomLayout htmlLayout2 = new CustomLayout(UIConst.COMMUN_DETAIL_LAYOUT);
				htmlLayout2.addStyleName("details_commun_layout");

				htmlLayout2.addComponent(new Label(title, Label.CONTENT_XHTML), "presentateur");

				if (desc != null) {
					htmlLayout2.addComponent(new Label(desc, Label.CONTENT_XHTML), "details");
				} else {
					String descContent = "";
					int i = 1;
					String paragraphe = "";

					while (paragraphe != null) {

						paragraphe = props.get(INFOSUTILES_PROP_PREFIX + "." + sort
								+ ".description.p" + i);

						if (paragraphe != null) {
							descContent += paragraphe + "<br/><br/>";
						}
						i++;
					}
					htmlLayout2
							.addComponent(new Label(descContent, Label.CONTENT_XHTML), "details");
				}

				// Use it as the layout of the Panel.
				this.addComponent(htmlLayout2);
			}

		}

	}

}
