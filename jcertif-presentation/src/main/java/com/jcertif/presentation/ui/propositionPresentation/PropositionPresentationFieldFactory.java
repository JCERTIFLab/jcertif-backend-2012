package com.jcertif.presentation.ui.propositionPresentation;

import java.util.List;
import java.util.Locale;

import com.jcertif.presentation.data.bo.participant.RoleParticipant;
import com.jcertif.presentation.data.bo.participant.TypeParticipant;
import com.jcertif.presentation.data.bo.presentation.Sujet;
import com.jcertif.presentation.internationalisation.Messages;
import com.jcertif.presentation.wsClient.RoleParticipantClient;
import com.jcertif.presentation.wsClient.SujetClient;
import com.jcertif.presentation.wsClient.TypeParticipantClient;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.TextField;
import com.vaadin.ui.TwinColSelect;
import com.vaadin.ui.VerticalLayout;

/**
 * Factory des champs du formulaire de proposition de sujet de présentation.
 * 
 * @author max
 * 
 */
public class PropositionPresentationFieldFactory extends VerticalLayout implements FormFieldFactory, Property.ValueChangeListener {

	private static final long serialVersionUID = 1L;

	/**
	 * @see com.vaadin.ui.FormFieldFactory#createField(com.vaadin.data.Item, java.lang.Object, com.vaadin.ui.Component)
	 */
	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {
		String pid = (String) propertyId;

		if (pid.equals("titre")) {
			return createTextField(Messages.getString("Presentation.proposition.title", Locale.getDefault()), true);
		} 
		else if (pid.equals("description")) {
			return createTextAreaField(Messages.getString("Presentation.proposition.description", Locale.getDefault()), true);
		} 
		else if (pid.equals("topic")) {
			return createTwinColumnSelectSujet(false); //createTextAreaField(Messages.getString("Presentation.proposition.description", Locale.getDefault()), true);
		}
		else if (pid.equals("sommaire")) {
			return createTextAreaField(Messages.getString("Presentation.proposition.sommary", Locale.getDefault()), true);
		} 
		else if (pid.equals("besoinsSpecifiques")) {
			return createTextField("Besoins specifiques", false);
		} 
		else if (pid.equals("keyWord")) {
			return createTextField("Mot clé", false);
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
            getWindow().showNotification(
                    "Catégorie sélectionnée : " + event.getProperty());
        }
    }

//    private static final String[] cities = new String[] { "Berlin", "Brussels",
//        "Helsinki", "Madrid", "Oslo", "Paris", "Stockholm" };

	public TwinColSelect createTwinColumnSelectSujet(boolean isRequired) 
	{
	    setSpacing(true);
	
	    TwinColSelect twinColSelect = new TwinColSelect();
	    initTwinColumnSujet(twinColSelect); 
//	    for (int i = 0; i < cities.length; i++) {
//	        l.addItem(cities[i]);
//	    }
	    twinColSelect.setRows(7);
	    twinColSelect.setNullSelectionAllowed(true);
	    twinColSelect.setMultiSelect(true);
	    twinColSelect.setImmediate(true);
	    twinColSelect.addListener(this);
	    twinColSelect.setRequired(isRequired);
	    //l.setLeftColumnCaption("Available cities");
	    //l.setRightColumnCaption("Selected destinations");
	    twinColSelect.setWidth("350px");
	
//	    addComponent(l);
	    return twinColSelect;
	}

	private void initTwinColumnSujet(TwinColSelect twinColSelect) {
		List<Sujet> sujetList = SujetClient.getInstance().findAllXML();
		for (Sujet type : sujetList) {
			twinColSelect.addItem(type.getLibelle());
		}
	}


}
