package com.jcertif.presentation.ui.propositionPresentation;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.presentation.Sujet;
import com.jcertif.presentation.internationalisation.Messages;
import com.jcertif.presentation.wsClient.SujetClient;
import com.sun.org.apache.commons.collections.CollectionUtils;
import com.sun.org.apache.commons.collections.Transformer;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Factory des champs du formulaire de proposition de sujet de présentation.
 * 
 * @author max
 * 
 */
public class PropositionPresentationFieldFactory extends VerticalLayout implements
		FormFieldFactory, Property.ValueChangeListener {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(PropositionPresentationForm.class);

	/**
	 * @see com.vaadin.ui.FormFieldFactory#createField(com.vaadin.data.Item,
	 *      java.lang.Object, com.vaadin.ui.Component)
	 */
	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {
		String pid = (String) propertyId;

		if (pid.equals("titre")) {
			return createTextField(
					Messages.getString("Presentation.proposition.title", Locale.getDefault()), true);
		} else if (pid.equals("description")) {
			return createTextAreaField(
					Messages.getString("Presentation.proposition.description", Locale.getDefault()),
					true);
		} else if (pid.equals("sujetStringList")) {
			return createOptionGroupSujet(
					Messages.getString("Presentation.proposition.subject", Locale.getDefault()),
					true); // createTextAreaField(Messages.getString("Presentation.proposition.description",
							// Locale.getDefault()), true);
		} else if (pid.equals("sommaire")) {
			return createTextAreaField(
					Messages.getString("Presentation.proposition.sommary", Locale.getDefault()),
					true);
		} else if (pid.equals("besoinsSpecifiques")) {
			return createTextField(
					Messages.getString("Presentation.proposition.needed", Locale.getDefault()),
					false);
		} else if (pid.equals("motCle")) {
			return createTextField(
					Messages.getString("Presentation.proposition.keyword", Locale.getDefault()),
					false);
		}
		return null;
	}

	private TextField createTextField(final String caption, final boolean isRequired) {
		TextField textField = new TextField(caption);
		textField.setRequired(isRequired);
		textField.setNullRepresentation("");
		textField.setColumns(40);
		textField.setValidationVisible(true);
		textField.setRequiredError("Le champ " + caption + " est obligatoire");
		return textField;
	}

	public TextField createTextAreaField(final String caption, final boolean isRequired) {
		TextField textField = new TextField(caption);
		textField.setRequired(isRequired);
		textField.setNullRepresentation("");
		textField.setColumns(40);
		textField.setRows(10);
		textField.setValidationVisible(true);
		textField.setRequiredError("Le champ " + caption + " est obligatoire");
		return textField;
	}

	/*
	 * Shows a notification when a selection is made.
	 */
	public void valueChange(ValueChangeEvent event) {
		if (!event.getProperty().toString().equals("[]")) {
			getWindow().showNotification("Catégorie sélectionnée : " + event.getProperty());
		}
	}

	private static final List<String> sujetList = Arrays.asList(new String[] { "Java Core",
			"Développement Mobiles", "Web 2.0", "Web sémantique" });

	public OptionGroup createOptionGroupSujet(final String caption, boolean isRequired) {
		setSpacing(true);

		// Create the multiselect option group
		// 'Shorthand' constructor - also supports data binding using Containers
		OptionGroup citySelect = new OptionGroup(caption, getSujetList()); // getSujetList()

		citySelect.setMultiSelect(true);
		citySelect.setNullSelectionAllowed(false); // user can not 'unselect'
		citySelect.setImmediate(false); // send the change to the server at once
		citySelect.setRequired(isRequired); // isRequired
		citySelect.setRequiredError("Le champ " + caption + " est obligatoire");

		// citySelect.addListener(this); // react when the user selects
		// something
		return citySelect;
	}

	private List<String> getSujetList() {
		List<Sujet> sujetList = SujetClient.getInstance().findAllXML();
		return (List<String>) CollectionUtils.collect(sujetList, new Transformer() {

			@Override
			public Object transform(Object suj) {
				return ((Sujet) suj).getLibelle();
			}
		});
	}

}
